<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>candidates List</h4>
            <ul>
                <li v-for="(candidate, index) in candidates" :key="index">
                    <router-link :to="{
                            name: 'add',
                            params: { candidateObj: candidate, id: candidate.id }
                        }">
                            {{candidate.firstName}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "candidates-list",
  data() {
    return {
      candidates: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrievecandidates() {
      http
        .get("/candidates")
        .then(response => {
          this.candidates = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrievecandidates();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrievecandidates();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>
