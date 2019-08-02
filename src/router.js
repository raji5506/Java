import Vue from "vue";
import Router from "vue-router";
import CandidatesList from "./components/CandidateList.vue";
import AddCandidate from "./components/AddCandidate.vue";
import SearchCandidates from "./components/SearchCandidates.vue";
import Candidate from "./components/Candidate.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "candidates",
      alias: "/candidate",
      component: CandidatesList,
      children: [
        {
          path: "/candidate/:id",
          name: "Candidate",
          component: AddCandidate,
          props: true
        }
      ]
    },
    {
      path: "/add",
      name: "add",
      component: AddCandidate
    },
    {
      path: 'candidate/:id',
      component: AddCandidate,
      name: 'Edit Candidate'
    },
    {
      path: "/search",
      name: "search",
      component: SearchCandidates
    }
  ]
});