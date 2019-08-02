<template>
  <div class="submitform">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="name">FirstName</label>
        <input
          type="text"
          class="form-control"
          id="firstname"
          required
          v-model="candidate.firstName"
          name="Firstname"
        />
      </div>
      <div class="form-group">
        <label for="name">LastName</label>
        <input
          type="text"
          class="form-control"
          id="lastname"
          required
          v-model="candidate.lastName"
          name="Lastname"
        />
      </div>
      <div class="form-group">
        <label for="name">UserName</label>
        <input
          type="text"
          class="form-control"
          id="username"
          required
          v-model="candidate.username"
          name="Username"
        />
      </div>

      <div class="form-group">
        <label for="age">Password</label>
        <input
          type="text"
          class="form-control"
          id="password"
          required
          v-model="candidate.password"
          name="Password"
        />
      </div>
      <div class="form-group">
        <label for="age">Email</label>
        <input
          type="text"
          class="form-control"
          id="email"
          required
          v-model="candidate.email"
          name="Email"
        />
      </div>
      <div class="form-group">
        <label for="age">PhoneNumber</label>
        <input
          type="number"
          class="form-control"
          id="phoneNumber"
          required
          v-model="candidate.phoneNumber"
          name="PhoneNumber"
        />
      </div>

      <div class="form-group">
        <label for="age">Address Line</label>
        <input
          type="text"
          class="form-control"
          id="addressLine1"
          required
          v-model="candidate.address.addressLine1"
          name="AddressLine1"
        />
      </div>

      <div class="form-group">
        <label for="age">City</label>
        <input
          type="text"
          class="form-control"
          id="city"
          required
          v-model="candidate.address.city"
          name="City"
        />
      </div>

      <button v-on:click="savecandidate" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" v-on:click="newcandidate">Add</button>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "add-candidate",
  props: ["id", "candidateObj"],
  data() {
    return {
      candidate: {},
      submitted: false
    };
  },
  async created() {
    if (this.$route.params.id) {
      this.candidate.id = this.$route.params.id;
      this.candidate = this.$route.params.candidateObj;
    } else {
      this.candidate = this.setEmptyData();
    }
  },
  methods: {
    /* eslint-disable no-console */
    savecandidate() {
      var data = this.setData();

      alert("ccccccc" + this.candidate.id);
      if (this.candidate.id == 0) {
        http
          .post("/candidate", data)
          .then(response => {
            this.candidate.id = response.data.id;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      } else {
        http
          .put("/candidate/" + this.candidate.id, data)
          .then(response => {
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }

      this.submitted = true;
    },
    newcandidate() {
      this.submitted = false;
      this.candidate =this.setEmptyData();
    },
    setData() {
      var data = {
        id: this.candidate.id,
        firstName: this.candidate.firstName,
        lastName: this.candidate.lastName,
        username: this.candidate.username,
        password: this.candidate.password,
        email: this.candidate.email,
        phoneNumber: this.candidate.phoneNumber,
        address: {
          addressLine1: this.candidate.address.addressLine1,
          city: this.candidate.address.city
        }
      };
      return data;
    },
    setEmptyData() {
      var data = {
        id: 0,
        firstName: "",
        lastName: "",
        username: "",
        password: "",
        email: "",
        phoneNumber: 0,
        address: {
          addressLine1: "",
          city: ""
        }
      };
      return data;
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
