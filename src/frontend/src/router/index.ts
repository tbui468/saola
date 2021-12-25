import { createWebHistory, createRouter } from "vue-router";
import Home from "@/views/Home.vue";
import Registration from "@/views/Registration.vue";
import Login from "@/views/Login.vue";
import StudentList from "@/views/StudentList.vue";

//describe all routes
const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/registration",
        name: "Registration",
        component: Registration,
    },
    {
        path: "/login",
        name: "Login",
        component: Login,
    },
    {
        path: "/students",
        name: "StudentList",
        component: StudentList,
    }
];

//shove those routes into router instance
const router = createRouter({
    history: createWebHistory(),
    routes,
});


export default router;
