<template>
  <v-container class="fill-height">
    <v-responsive
      class="align-centerfill-height mx-auto"
      max-width="900"
    >
    <v-data-table :items="clients" @click:row="editClient" />

    <v-dialog v-model="clientDialog">
      <v-card>
        <v-card-title class="text-h5">{{ (isUpdateMode ? "Edit" : "Create") + " " + "Client" }}</v-card-title>
        <v-container>
          <v-text-field v-if="isUpdateMode" v-model="client.id" disabled></v-text-field>
          <v-text-field v-model="client.name"></v-text-field>
        </v-container>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="clientDialog = false">Cancel</v-btn>
          <v-btn color="success" text @click="deleteTag">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    </v-responsive>
  </v-container>
</template>

<script>
import axios from 'axios';


export default {
  data() {
    return {
      clientIdx: -1,
      client: {},
      clients: [
        {
          id: '4636d367-876c-8274-6578-f938466fcd4',
          name: 'John Doe',
        }
      ],
      clientDialog: false,
      isUpdateMode: false
    };
  },
  watch: {
    clientDialog() {
      if (!this.clientDialog)
      {
        this.resetClient()
        this.isUpdateMode = false
      }
    }
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
      }
    },
    editClient(event)
    {
      this.clientIdx = Array.from(event.target.closest('tr').parentNode.children).indexOf(event.target.closest('tr'))
      this.client = this.clients[this.clientIdx]
      this.isUpdateMode = true
      this.clientDialog = true
    },
    resetClient()
    {
      this.clientIdx = -1
      this.client = {}
    }
  }
}

</script>
