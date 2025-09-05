const person = {
    name:"Omkar",
    address: {
        line1: "Talbot Street",
        city: "Dublin",
        country: "Ireland",
    },
    profiles: ["Twitter","Instagram","Linkden"],
    printProfile: () => {
        person.profiles.map(
            (profile) => {
                console.log(profile)
            }
        )
    }
}

export default function LearningJavaScript() {
    return (
        <>
            <div>
                {person.name } is Learning JavaScript 
            </div>
            <div>
                {person.address.line1} <br />
                {person.address.city} <br />
                {person.address.country} <br />
                {person.profiles}
                {person.printProfile() }
            </div>
        </>
    )
}