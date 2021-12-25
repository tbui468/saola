<template>
    <h1>Login page</h1> 
    <form @submit.prevent="handleSubmit">
        <label>Username</label>
        <input name="username" v-model="username" required>
        <label>Password</label>
        <input type="password" name="password" v-model="password" required>

        <div class="submit">
            <button>Login</button>
        </div>
    
    </form>
    <h3>New user?</h3>
    <button @click="$router.push('Registration')">Create a new account</button>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    methods: {
        async handleSubmit() {
            const res = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {'Content-type': 'application/json'},
                body: JSON.stringify({
                    username: this.username,
                    password: this.password 
                })
            })
            .then(res => res.json())
            .then(json => localStorage.setItem('myJwt', json.jwt));
            //const content = await res.json();
            //console.log("content:", content); //content.jwt holds the ... jwt - gotta save that in local storage and send it with requests
            //localStorage.getItem('myJwt') //put this inside header 'Authorizatin': 'Bearer [token]' with every request
            //localStorage.removeItem('myJwt'); //call this when user logs out
           
        }
    },
    data () {
        return {
            username: '' as string,
            password: '' as string,
        }
    }
});
</script>
