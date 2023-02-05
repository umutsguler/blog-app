import {useEffect, useState} from "react";

interface Person {
    name: string;
    age: number;
}

class Person {
    name: string;
    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }
}

export default function About() {

    const [as, setAs] = useState({name: "Mehmet", age: 25});

    console.log(as, "as");

    const handleAs = (test:string,tst:string) => {
        setAs({name: test, age: tst});
    };

    const person = new Person("Mehmet", 25);
    console.log(person.name, "person.name");
    let b = 1;

    const a: Person = {
        name: "Mehmet",
        age: 25
    }

    console.log(a);

    console.log(b);
    const [counter, setCounter] = useState(0);

    console.log(a, "next js 2  ksez yazıyor bunu engellemeliyim");

    useEffect(() => {
        console.log("useEffect çalıştı");
    }, [counter]);
    const handleCounter = () => {
        setCounter(counter + 1);
    };

    return (
        <>
            <div className="text-lg bg-amber-400 h-screen">
                <div>
                    {" "}dsdddd
                    Blog Project Birader bune ya intelli ile frontend yazılıyor mu{" "}
                </div>
                <div>Yazılıyormuş galiba</div>
                <button onClick={()=>handleAs("umut","umut2")}>Arttır</button>
            </div>
        </>
    );
}
