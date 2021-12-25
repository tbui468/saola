<template>
    <h1>Registration page</h1>
    <form @submit.prevent="handleSubmit">
        <label>Username</label>
        <input name="username" v-model="username" required>
        <label>Password</label>
        <input type="password" name="password" v-model="password" required>
        <div v-if="passwordError">{{ passwordError }}</div>

        <div class="terms">
            <input type="checkbox" v-model="terms" required>
            <label>Accept terms and conditions</label>
        </div>
        <div class="submit">
            <button>Create an account</button>
        </div>
    </form>
    <h3>Already have an account?</h3>
    <button @click="$router.push('Login')">Login with an existing account</button>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'HelloWorld',
    props: ['registerRoute'],
    methods: {
        async handleSubmit() {
            this.passwordError = this.password.length > 5 ?
                '' : 'Password must be at least 6 chars long';

            if (!this.passwordError) {
                console.log("submitted form");
                const res = await fetch('http://localhost:8080/register', {
                    method: 'POST',
                    headers: { 'Content-type': 'application/json' },
                    body: JSON.stringify({
                        username: this.username,
                        password: this.password,
                    })
                });
                const content = await res.json();
                console.log('jwt:', content);
            }
        },
    },
    data() {
        return {
            username: '' as string,
            password: '' as string,
            terms: false as boolean,
            passwordError: '' as string,
        }
    },
});
    
</script>

<style>
    form {
        max-width: 420px;
        margin: 30px auto;
        background: white;
        text-align: left;
        padding: 40px;
        border-radius: 10px;
    }
    label {
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.6em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
    }
    input, select {
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
    }
    input[type="checkbox"] {
        display: inline-block;
        width: 16px;
        margin: 0 10px 0 0;
        position: relative;
        top: 2px;
    }
    button {
        background: #0b6dff;
        border: 0;
        padding: 10px 20px;
        margin-top: 20px;
        color: white;
        border-radius: 20px;
    }
    .submit {
        text-align: center;
    }
</style>
