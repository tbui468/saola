<template>
    <h1>Students List</h1>
    <form @submit.prevent="submitForm">
        <input type="text" v-model="name" placeholder="name">
        <button type="submit">Add student</button>
    </form>
    <table>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        <tr v-for="student in students" v-bind:key="student.id">
            <td>{{student.id}}</td>
            <td>{{student.name}}</td>
            <td><input type="button" value="update"></td>
            <td><input type="button" @click="onDelete(student.id)" value="delete"></td>
        </tr>
    </table>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'HelloWorld',
    data() {
        return { 
            students: [] as string[],
            name: '' as string, //probably doesn't need to be 'data', right?
            showModal: false as boolean
        }
    },
    mounted() {
        this.getData();
    },
    updated() {
        this.getData(); //can put this in updated() lifecycle hook
    },
    methods: {
        async submitForm() {
            const res = await fetch('/api/students', {
                method: 'POST',
                headers: { 'Content-type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem('myJwt') },
                body: JSON.stringify({
                    name: this.name,
                })
            });
            this.name = ''; //can we clear it in the html
        },
        async onDelete(id: number) {
            console.log("clicked delete");
            const res = await fetch('/api/students/' + id, {
                method: 'DELETE',
            });
        },
        getData() {
            fetch("/api/students", {
                headers: { 'Authorization': 'Bearer ' + localStorage.getItem('myJwt')}
            })
            .then((response) => response.text())
            .then((data) => {
                this.students = JSON.parse(data);
            });
        }
    }
});
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    table {
        margin: 30px auto;
    }
</style>
