<template>
  <div>
        <h2 class="text-center">Vue를 이용한 게시판</h2>
        <table class="table table-condensed w-25">
        <tr>
            <th>아이디</th>
            <td v-text="board.id"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td v-text="board.name"></td>
        </tr>
        <tr>
            <th>부서</th>
            <td v-text="board.dept_name"></td>
        </tr>
        <tr>
            <th>직급</th>
            <td v-text="board.title"></td>
        </tr>
        <tr>
            <th>월급</th>
            <td v-text="board.salary"></td>
        </tr>
        <tr>
            <td colspan="2" v-text="board.content"></td>
        </tr>
        </table>
        <div  class='text-right'>
            <router-link  class='btn btn-primary' to='/list'>목록</router-link>
            <router-link  class='btn btn-primary' :to="'/update?id='+board.id">수정</router-link>
            <router-link  class='btn btn-primary' :to="'/delete?id='+board.id">삭제</router-link>
        </div>
    </div>
</template>
<script>

import axios from "axios";

export default {
  data() {
    return {
      board: {}
    };
  },
  created() {
      const params = new URL(document.location).searchParams;
      axios.get(`http://localhost:8097/hrmboot/api/employee/${params.get('id')}`)
          .then(({ data }) => {
              this.board = data
          })
          .catch(error => {
            alert(error);
          });
  },
  name:`detail`
}
</script>

  