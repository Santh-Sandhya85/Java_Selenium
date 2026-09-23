describe('SauceDemo Login', () => {

    it('should login successfully', () => {

        cy.visit('https://www.saucedemo.com/');

        cy.get('#user-name')
            .type('REMOVED_USERNAME');

        cy.get('#password')
            .type('REMOVED_PASSWORD');

        cy.get('#login-button')
            .click();

        cy.url()
            .should('include', 'inventory');

    });

});