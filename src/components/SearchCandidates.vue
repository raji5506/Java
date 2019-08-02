<template>
  <div class="searchform">
    <h4>Find by email</h4>
    <div class="form-group">
      <input type="text" class="form-control" id="email" required v-model="email" name="email">
    </div>
 
    <div class="btn-group">
      <button v-on:click="searchcandidates" class="btn btn-success">Search</button>
    </div>

    <ul class="search-result">
      <li v-for="(candidate, index) in candidates" :key="index">
        <h6>{{candidate.firstName}} ({{candidate.email}})</h6>
      </li>
    </ul>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-candidate",
  data() {
    return {
      email:"",
      candidates: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    searchcandidates() {
      http
        .get("/candidates/email/" + this.email)
        .then(response => {
          this.candidates = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>