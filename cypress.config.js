const { defineConfig } = require("cypress");
require("dotenv").config();

module.exports = defineConfig({
  env: {
    sauceUsername: process.env.SAUCE_USERNAME,
    saucePassword: process.env.SAUCE_PASSWORD,
  },
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
