<template>
  <v-container class="fill-height">
    <v-responsive
      class="align-centerfill-height mx-auto"
      max-width="900"
    >
    <v-container class="d-flex align-center pe-2">
      <h1>Clients</h1>
      <v-spacer />
      <v-btn class="ma-2" icon="mdi-plus-circle-outline" color="green" size="large" @click="createClient"></v-btn>
    </v-container>

    <v-data-table :items="clients" :headers="headers">
      <template v-slot:item.actions="{ item }">
        <v-icon
          size="large"
          color="yellow"
          @click="editClient(item)"
        >
          mdi-pencil
        </v-icon>
        <v-icon
          size="large"
          color="red"
          @click="deleteClient(item)"
        >
          mdi-delete
        </v-icon>
      </template>
    </v-data-table>

    <v-dialog v-model="clientDialog">
      <v-card>
        <v-card-title class="text-h5">{{ (isUpdateMode ? "Edit" : "Create") + " " + "Client" }}</v-card-title>
        <v-container>
          <v-text-field v-if="isUpdateMode" v-model="client.id" disabled></v-text-field>
          <v-text-field v-model="client.name" label="Name"></v-text-field>
        </v-container>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="clientDialog = false">Cancel</v-btn>
          <v-btn color="success" text @click="saveClient">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-dialog v-model="clientDeleteDialog" max-width="500px">
      <v-card>
        <v-card-title class="text-h5 card">Are you sure that you want to delete 
          <span class="text-red text--darken-2">{{ this.client.name }}</span>?
        </v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" variant="text" @click="clientDeleteDialog = false">Cancel</v-btn>
          <v-btn color="red" variant="text" @click="removeClient">Delete</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-snackbar 
      v-model="snackbar.show"
      :timeout="3000"
      :color="snackbar.color"
      elevation="24"
    >
      {{ this.snackbar.message }}
    </v-snackbar>

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
      clientDeleteDialog: false,
      isUpdateMode: false,
      headers: [
        {title: "Id", key: "id"},
        {title: "Name", key: "name"},
        {title: "", key: "actions"}
      ],
      snackbar: {
        show: false,
        color: "green",
        message: ''
      }
    };
  },
  watch: {
    clientDialog() {
      if (!this.clientDialog)
      {
        this.resetClient()
        this.isUpdateMode = false
      }
    },
    clientDeleteDialog() {
      if (!this.clientDeleteDialog)
      {
        this.resetClient()
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
    editClient(client)
    {
      this.clientIdx = this.clients.indexOf(client)
      this.client = {...this.clients[this.clientIdx]}
      this.isUpdateMode = true
      this.clientDialog = true
    },
    resetClient()
    {
      this.clientIdx = -1
      this.client = {}
    },
    async saveClient()
    {
      if (this.isUpdateMode)
      {
        try {
          const response = await axios.put(`http://localhost:8080/clients/${this.client.id}`, { name: this.client.name })
          this.clients[this.clientIdx] = this.client
          this.showSnackbar("Client updated successfully", "green")
        } catch(e) {
          console.error(`Failed to edit client (${e})`)
          this.showSnackbar("Failed to update the client info", "red")
        }
      } else {
        try {
          const response = await axios.post("http://localhost:8080/clients", { name: this.client.name })
          this.clients.unshift(response.data)
          this.client = response.data
          this.showSnackbar("Client saved successfully", "green")
          this.isUpdateMode = true
        } catch(e) {
          console.error(`Failed to save client (${e})`)
          this.showSnackbar("Failed to save the client", "red")
        }
      }
    },
    createClient()
    {
      this.clientDialog = true
    },
    deleteClient(client)
    {
      this.clientIdx = this.clients.indexOf(client)
      this.client = client
      this.clientDeleteDialog = true
    },
    async removeClient()
    {
      try {
        const response = await axios.delete(`http://localhost:8080/clients/${this.client.id}`)
        this.clients.splice(this.clientIdx, 1)
        this.clientDeleteDialog = false
        this.showSnackbar("Client removed successfully", "green")
      } catch (e) {
        console.error(`Failed to delete client (${e})`)
        this.showSnackbar("Failed to remove the client", "red")
      }
    },
    showSnackbar(msg, color)
    {
      this.snackbar.message = msg
      this.snackbar.color = color
      this.snackbar. show = true
    }
  }
}

</script>

<style scoped>
.card {
  white-space: normal;
}
</style>