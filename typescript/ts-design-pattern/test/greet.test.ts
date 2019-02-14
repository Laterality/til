import { greet } from "../src/greet";

describe("Greeter Test", () => {
    it("Return with right name", () => {
        greet("John").should.equal("hello, John!");
        greet(String(1234)).should.equal("hello, 1234!");
    });

    it("Throwing error when called with undef.", () => {
        (() => {
            greet(undefined);
        }).should.throw();
    });
});