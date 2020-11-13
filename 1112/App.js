import Index from "./components/index.js";
import List from "./components/List.js";
Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "index",
      component: Index
    },
    {
      path: "/list",
      name: "list",
      component: List
    },
  ]
});
