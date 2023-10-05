<script setup>

</script>

<template>


  <header>
    <h2 class="text-4xl font-bold tracking-tight sm:text-6xl">Car Rental Service</h2>
  </header>
  <body>
      <div class="text-center mt-8">
        <nav>
          <div class="grid text-base font-semibold leading-7 pb-4 sm:grid-cols-2 md:flex lg:gap-x-10">
            <RouterLink to="/">
              <button>Home</button>
            </RouterLink>
            <RouterLink to="/vehicles">
              <button>List all vehicles</button>
            </RouterLink>
          </div>
        </nav>
      </div>
      <RouterView/>
  </body>

</template>

<style scoped>


</style>

