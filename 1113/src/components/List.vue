<template>
  <div>
      <h2 class="text-center">Vue를 이용한 게시판</h2>
      <div class="text-right">
        <button class="btn btn-primary" @click="movePage">등록</button>
      </div>
      <div v-if="boards.length">
        <div class="text-center">
          <input type="text" v-model="sname" />
          <button @click="searchName">검색</button>
        </div>
        <table class="table table-boarded table-condensed">
          <tr>
            <td>아이디</td>
            <td>이름</td>
            <td>부서</td>
            <td>직책</td>
            <td>월급</td>
          </tr>
          <tr v-for="(board, index) in boards" :key="index">
            <td>
              <router-link :to="'detail?id='+board.id"
                >{{board.id}}</router-link
              >
            </td>
            <td v-text="board.name"></td>
            <td v-text="board.dept_name"></td>
            <td v-text="board.title"></td>
            <td v-text="board.salary"></td>
          </tr>
        </table>
      </div>
      <div v-else>
        <h3 class="text-center">게시글이 없습니다</h3>
      </div>
    </div>
</template>
<script>

import axios from "axios";

    export default {
        data() {
    return {
      boards: [], //화면에 표시할 board
      src: [], //localStorage에서 추출한 board 원본
      sname: ""
    };
  },
  methods: {
    movePage: function() {
      this.$router.push("/create");
    },
    searchName: function() {
      if (this.sname != "") {
        // this.boards = this.src.filter( board =>{
        //     return this.sname == board.writer
        // })
        const temp = [];
        for (let board of this.src) {
          if (this.sname == board.writer) {
            temp.push(board);
          }
        }
        this.boards = temp;
      } else {
        this.boards = this.src;
      }
    }
  },
  created() {
    axios
      .get("http://localhost:8097/hrmboot/api/employee/all")
      .then(response => {
        this.src = response.data;
        this.boards = response.data;
      })
      .catch(error => {
        alert(error);
      });
  }
}
</script>

  