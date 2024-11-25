<template>
  <v-container class="fill-height">
    <v-responsive
      class="align-centerfill-height mx-auto"
      max-width="900"
    >
    <v-data-table :items="clients"></v-data-table>
    </v-responsive>
  </v-container>
</template>

<script>
import axios from 'axios';


export default {
  data() {
    return {
      clients: [
        {
          id: '4636d367-876c-8274-6578-f938466fcd4',
          name: 'John Doe',
        }
      ]
    };
  },
  mounted()
  {
    this.getAllClients();
  },
  methods: {
    async getAllClients()
    {
      try {
        const response = await axios.get('http://localhost:8080/clients')
        this.clients = response.data
      } catch (e) {
        console.error(`Error on getting all clients (${e})`)
      } finally {
        this.clients.reset()
      }
    }
  }
}

</script>
