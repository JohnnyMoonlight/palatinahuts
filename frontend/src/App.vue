<template>
  <v-container>
    <v-app id="app">
      <v-navigation-drawer class="pt-4" app permanent>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="text-h6">
              Von Hütte zu Hütte
            </v-list-item-title>
            <v-list-item-subtitle>
              Wandern im Pfälzerwald
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <div v-for="item in navigationItems" :key="item.text">
          <v-list-item :id="item.id" :to="item.path">
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>
            <v-list-item-title>{{ item.text }}</v-list-item-title>
          </v-list-item>
          <b-tooltip delay="250" hide="100" :target="item.id"
            >{{ item.tooltip }}
          </b-tooltip>
        </div>
      </v-navigation-drawer>
      <v-main>
        <div v-for="item in navigationItems" :key="item.text"></div>
        <router-view />
      </v-main>
    </v-app>
  </v-container>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

<script>
export default {
  setup() {},
  data: () => ({
    navigationItems: [
      {
        path: "/map",
        id: "map_navigator",
        icon: "mdi-map",
        text: "Karte",
        tooltip: "Hütten auf einer Kartenansicht",
      },
      {
        path: "/huts",
        id: "huts",
        icon: "mdi-view-list",
        text: "Liste",
        tooltip: "Hütten in Listenform",
      },
      {
        path: "/hutmanagement",
        id: "hutmanagement",
        icon: "mdi-home-outline",
        text: "Neue Hütte erstellen",
        tooltip: "Hütten hinzufügen",
      },
      {
        path: "/moderation",
        id: "moderation",
        icon: "mdi-file-find",
        text: "Moderation",
        tooltip: "Inhalte moderieren",
      },
      {
        path: "/settings",
        id: "settings_navigator",
        icon: "mdi-wrench",
        text: "Einstellungen",
        tooltip: "Einstellungen ändern",
      },
      {
        path: "/about",
        id: "about_navigator",
        icon: "mdi-information-outline",
        text: "Info",
        tooltip: "Über App und Author",
      },
    ],
  }),
};
</script>
