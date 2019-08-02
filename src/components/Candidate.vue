<template>
  <div v-if="this.candidate">
    <h4>candidate</h4>
    <div>
      <label>FirstName:</label>
      {{this.candidate.firstName}}
    </div>
    <div>
      <label>LastName:</label>
      {{this.candidate.lastName}}
    </div>
    <div>
      <label>UserName:</label>
      {{this.candidate.username}}
    </div>
    <div>
      <label>Password:</label>
      {{this.candidate.password}}
    </div>
    <div>
      <label>Email:</label>
      {{this.candidate.email}}
    </div>

    <div>
      <label>Address Line:</label>
      {{this.candidate.address.addressLine1}}
    </div>

    <div>
      <label>City:</label>
      {{this.candidate.address.city}}
    </div>

    <span
      v-if="this.candidate.username"
      v-on:click="updatecandidate(true)"
      class="button is-small btn-primary"
    >Edit</span>
     

    <span class="button is-small btn-danger" v-on:click="deletecandidate()">Delete</span>
  </div>
  <div v-else>
    <br />
    <p>Please click on a candidate...</p>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "candidate",
  props: ["candidate"],
  methods: {
    /* eslint-disable no-console */
    updatecandidate(status) {
      var data = {
        id: this.candidate.id,
        firstName: this.candidate.firstName,
        lastName: this.candidate.lastName,
        username: this.candidate.username,
        password: this.candidate.password,
        email: this.candidate.email,
        phoneNumber: this.candidate.phoneNumber,
        address:{ addressLine1: this.candidate.addresss.addressLine1,
        city: this.candidate.addresss.city }
      };

      http
        .put("/candidate/" + this.candidate.id, data)
        .then(response => {
          
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deletecandidate() {
      http
        .delete("/candidate/" + this.candidate.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push("/");
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>