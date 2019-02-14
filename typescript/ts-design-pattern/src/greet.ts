export function greet(name?: string): string {
    if (!name) {
        console.log("error");
        throw new Error();
    }
    return `hello, ${name}!`;
}

function hello(name: string): void {
    console.log(greet(name));
}

hello("world");