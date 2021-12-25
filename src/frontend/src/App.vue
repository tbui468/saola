<template>
    <div id="nav">
        <router-link :to="{ name: 'Home' }">Home</router-link> |
        <router-link :to="{ name: 'Registration'}">Registration</router-link> |
        <router-link :to="{ name: 'StudentList' }">StudentList</router-link>
    </div>
    <router-view />
</template>

<script lang="ts">
import { defineComponent } from 'vue';

//home page should just be Login + Register buttons
//Registration page should also include a Login button
//Login page should include a Register button
//'fetch' doesn't seem to need 'await' keyword...

export default defineComponent({
    name: 'App',
    data() {
        return {
            showModal: false as boolean,
        }
    }
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 960px;
  margin: 0 auto;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
  padding: 10px;
  border-radius: 4px;
}
#nav a.router-link-exact-active {
  color: white;
  background: crimson;
}
body {
    margin: 0;
    background: #eee;
}
</style>
