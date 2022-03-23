<template>
  <div class="home">
    <v-container>
      <v-data-table
        @click:row="announceClickedHut"
        :headers="headers"
        :items="huts"
      >
        <template v-slot:[`item.primaryIcon`]="{ item }">
          <v-avatar size="62" class="justify-start"
            ><img :src="item.primaryIcon" /></v-avatar
        ></template>
        <template v-slot:[`item.price`]="{ item }"
          ><v-chip :color="getColor(item.price)">{{
            item.price
          }}</v-chip></template
        >
        <template v-slot:[`item.diameter`]="{ item }">
          <v-chip>{{ item.diameter ? item.diameter : " - " }}</v-chip>
        </template>
      </v-data-table></v-container
    >
  </div>
</template>

<script>
import API from "../api/api";

export default {
  name: "HutList",
  mounted() {
    API.getHuts().then((data) => (this.huts = data));
  },
  methods: {
    announceClickedHut: function (a, b) {
      let hut = b.item;
      this.$emit("detailHutAnnounced", hut);
    },
    getColor: function (price) {
      if (price < 4) return "green";
      if (4 < price < 4.5) return "yellow";
      else return "red";
    },
  },
  data: () => ({
    detail: "",
    huts: [],
    headers: [
      {
        text: "",
        value: "primaryIcon",
        width: "20px",
        sortable: false,
      },
      {
        text: "Pfalzhütte",
        value: "name",
      },

      {
        text: "Rieslingschorle (€/0.5L)",
        value: "price",
      },

      {
        text: "Leberknödeldurchmesser (mm)",
        value: "diameter",
      },
    ],
  }),
};
</script>
