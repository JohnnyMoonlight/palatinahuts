<template>
  <v-container>
    <v-form
      ><v-row
        ><v-col lg="6" md="12">
          <v-text-field
            v-model="hutName"
            :counter="80"
            label="Name"
            required
          ></v-text-field>
        </v-col>

        <v-col lg="6" md="12">
          <v-select :items="assocations" label="Manager" required></v-select>
        </v-col>
        <v-col lg="12" md="12" xs="12" style="height: 50vh">
          <HutMap
            v-on:mapclicked="getLatLongFromMapClick"
            latitude="49.308592000000004"
            longitude="7.892475186106314"
            zoomLevel="9"
            style="width: 100%"
            setPinOnClick="true"
          ></HutMap
        ></v-col> </v-row
      ><v-row
        ><v-col lg="6" md="6">
          <v-text-field
            v-model="latitude"
            label="Latitude"
            required
            disabled
          ></v-text-field></v-col
        ><v-col lg="6" md="6">
          <v-text-field
            v-model="longitude"
            label="Longitude"
            required
            disabled
          ></v-text-field
        ></v-col>
        <v-row
          ><v-col lg="6" md="6">
            <v-text-field
              v-model="place"
              label="Ort"
              required
            ></v-text-field></v-col
        ></v-row> </v-row
      ><v-row
        ><v-col md="12" xs="12">
          <v-file-input
            label="Bilder"
            multiple
            show-size
            truncate-length="15"
            v-on:change="getFiles"
          ></v-file-input>
        </v-col> </v-row
      ><v-row
        ><v-col lg="4" md="4">
          <v-text-field
            v-model="price"
            label="Rieslingschorle (€/0.5L)"
            required
          ></v-text-field></v-col
        ><v-col lg="4" md="4">
          <v-text-field
            v-model="diameter"
            label="Leberknödeldurchmesser (mm)"
            required
          ></v-text-field></v-col
        ><v-col lg="4" md="4">
          <v-switch v-model="playground" label="Spielplatz verfügbar"></v-switch
        ></v-col>
      </v-row>
      <v-row
        ><v-col lg="3">
          <v-btn
            @click="saveHut"
            color="success"
            :loading="ui.loading"
            :disabled="isInvalid"
            >Speichern</v-btn
          ></v-col
        ><v-col lg="3">
          <v-snackbar v-model="ui.snackbar">
            {{ ui.message }}

            <template v-slot:action="{ attrs }">
              <v-btn
                :color="ui.color"
                text
                v-bind="attrs"
                @click="ui.snackbar = false"
              >
                Close
              </v-btn>
            </template>
          </v-snackbar>
        </v-col>
      </v-row>
    </v-form>
  </v-container>
</template>
<style>
</style>
<script>
import HutMap from "../components/HutMap.vue";
import API from "../api/api";
import Hut from "../model/hut";

export default {
  data: function () {
    return {
      hutName: "",
      assocations: ["PWV", "NF"],
      place: "",
      images: "",
      latitude: null,
      longitude: null,
      diameter: null,
      price: null,
      playground: false,
      ui: {
        loading: false,
        response: null,
        snackbar: false,
        message: "",
        color: "red",
      },
    };
  },
  components: { HutMap },
  mounted() {},
  computed: {
    isInvalid() {
      if (
        this.hutName != "" &&
        this.latitude != null &&
        this.longitude != null
      ) {
        return false;
      } else {
        return true;
      }
    },
  },
  methods: {
    getLatLongFromMapClick(latlng) {
      this.latitude = latlng.lat;
      this.longitude = latlng.lng;
    },

    createNewHutFromInput() {
      return new Hut(
        this.hutName,
        this.price,
        this.place,
        this.diameter,
        this.playground,
        this.latitude,
        this.longitude,
        true
      );
    },
    async saveHut() {
      this.ui.loading = true;
      this.ui.response = await API.createHut(
        this.createNewHutFromInput(),
        this.images
      );
      if (this.ui.response.status == "201") {
        this.ui.color = "green";
        this.ui.message = "Hütte erfolgreich angelegt.";
      } else {
        this.ui.color = "red";
        this.ui.message = this.response;
      }
      this.ui.loading = false;
      this.ui.snackbar = true;
    },
    getFiles(e) {
      this.images = e;
    },
  },
};
</script>
