<script setup>
import { RouterLink, RouterView } from 'vue-router'
// import HelloWorld from './components/HelloWorld.vue'

</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
    <h1>MSA<span id="title">Car Rental</span></h1>

    <div class="wrapper">
<!--      <HelloWorld msg="You did it!" />-->

      <nav>
        <RouterLink to="/">Home</RouterLink>
<!--        <RouterLink to="/about">About</RouterLink>-->
        <router-link to="/vehicles">Vehicles</router-link>
        <router-link to="#">Account</router-link>

      </nav>
    </div>
  </header>

<!--  <ul>-->
    <RouterView />
<!--  </ul>-->

</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

h1 {
  display: flex;
  flex-direction: column;
  text-align: end;
  margin: 10px;
  color: #34495e;
  text-decoration-line: underline;
}
#title{
  color: #41b883;

}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    //padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    font-size: 1rem;
    padding: 1rem 0;
  }
}
</style>
