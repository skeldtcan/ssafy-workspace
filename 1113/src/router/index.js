import Vue from "vue";
import VueRouter from "vue-router";
import List from "../components/List.vue";
import Detail from "../components/Detail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/list",
    name: "list",
    component: List
  },
  {
    path: "/detail",
    name: "detail",
    component: Detail
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
