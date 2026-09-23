describe('SauceDemo Login', () => {

    it('should login successfully', () => {

        cy.visit('https://www.saucedemo.com/');

        cy.get('#user-name')
            .type(Cypress.env('sauceUsername'));

        cy.get('#password')
            .type(Cypress.env('saucePassword'));

        cy.get('#login-button')
            .click();

        cy.url()
            .should('include', 'inventory');

    });

});