<template>
    <div class="app">
        <TopNav />
        <SideNav />
        <Board msg="Current Students"/>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Board from './components/Board.vue';
import TopNav from './components/TopNav.vue';
import SideNav from './components/SideNav.vue';
//import Modal from './components/Modal.vue';

export default defineComponent({
    name: 'App',
    components: {
        Board,
        TopNav,
        SideNav,
//        Modal
    },
    data() {
        return {
            showModal: false as boolean
        }
    }
});
</script>

<style>
    .app {
        margin-top: 44px;
    }    
</style>
