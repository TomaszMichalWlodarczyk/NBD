printjson(db.people.insert({
    sex : "Male",
    first_name : "Tomasz",
    last_name : "Wlodarczyk",
    job : "Dev",
    email : "s4503@pjwst.edu.pl",
    location: {
        city : "Warsaw",
        address: {
            streetname : "Testowea",
            streetnumber : "35"
            },
        },
    description: "",
    height: "178",
    weight:"90",
    birth_date:"1986-07-08T00:00:00Z",
    nationality:"Poland",
    credit: [
        {
            type : "laser",
            number : "2221110001112220",
            currency : "PLN",
            balance : "999",
            },
        ]
    }))