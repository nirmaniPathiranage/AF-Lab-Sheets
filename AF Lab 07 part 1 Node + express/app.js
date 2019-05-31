const express = require('express');
const bodyParser = require('body-parser');
const userObject = require('./User');

const app = express();
const userArray = [];

app.use(bodyParser.json());

//creates a server that listens on port 3000

app.listen(3000, err => {
    if (err) {
        console.error(err);
        return;
    }
    console.log('Server listens on port : 3000');
});

//POST method to add a user object to the array

app.post('/add', (req, res) => {
    try {
        const user = req.body;
        const user1 = new userObject(user.fName, user.lName, new Date(user.birth), Date.now());
        userArray.push(user1);

        res.status(200).send({ message: 'User added to the Array', data: user1 });
    } catch (e) {
        res.status(500).send({ message: e });
    }
});

//GET method to get all users

app.get('/getall', (req, res) => {
    try {
        res.status(200).send({ message: 'All users are displayed in the array', data: userArray });
    } catch (e) {
        res.status(500).send({ message: e });
    }
});

//GET method to get a particular user by id

app.get('/getbyid/:ID', (req, res) => {
    try {
        const index = userArray.findIndex(x => x.id == req.params.ID);
        if (index > -1) {
            res.status(200).send(userArray[index]);
        }
        else {
            res.status(404).send({ message: 'Invalid ID Provided' });
        }
    } catch (e) {
        res.status(500).send({ message: e });
    }
});

//PUT method to update a particular user by id

app.put('/updatebyid/:ID', (req, res) => {
    try {
        const index = userArray.findIndex(y => y.id == req.params.ID);
        const user = req.body;

        if (index > -1) {
            userArray[index].firstname = user.fName;
            userArray[index].lastname = user.lName;
            userArray[index].birthday = user.birth;

            res.status(200).send(userArray[index]);
        }
        else {
            res.status(404).send({ message: 'Invalid ID Provided' });
        }
    } catch (e) {
        res.status(500).send({ message: e });
    }
});

//DELETE method to delete a particular user by id

app.delete('/deletebyid/:ID', (req, res) => {
    try {
        const index = userArray.findIndex(z => z.id == req.params.ID);
        if (index > -1) {
            const deleteUser = userArray.splice(index, 1);
            res.status(200).send({ message: 'User removed from the Array', removedObject: deleteUser, data: userArray });
        }
        else {
            res.status(404).send({ message: 'Invalid ID Provided' });
        }
    } catch (e) {
        res.status(500).send({ message: e });
    }
});