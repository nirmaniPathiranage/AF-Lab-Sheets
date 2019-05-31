'use strict';

const express = require('express');
const mongoose = require('mongoose');

mongoose.Promise = global.Promise;

const app = express();

app.use(express.json());

mongoose.connect('mongodb://localhost:27017/expressjsSample', err => {
    if(err){
        console.log(err);
        process.exit(1);
    }
});

const UserModel = require('./src/DBSchema/DBSchema');



//creates the server which listens on port number 3000

app.listen(3000, err => {
    if(err){
        console.error(err);
        return;
    }
    console.log('Server listens on port : 3000');
});



//POST method to add a user to the database

app.post('/users', (req, res) => {
    const user = new UserModel(req.body);
    user.save().then(user => {
        res.json(user);
    }).catch(err => {
        console.error(err);
        res.sendStatus(500);
    });
});



//GET method to fetch all the users in the database

app.get('/users', (req, res) => {
    UserModel.find().exec().then(users => {
        res.json(users);
    }).catch(err => {
        console.error(err);
        res.sendStatus(500);
    });
});



//GET method to fetch a particular user based on his/her id in the database

app.get('/users/:id', (req, res) => {
    UserModel.findById(req.params.id).exec().then(user => {
        res.json(user || {});
    }).catch(err => {
        console.error(err);
        res.sendStatus(500);
    });
});



//PUT method to update a particular user based on his/her id in the database

app.put('/users/:id', (req, res) => {
    const user = new UserModel(req.body);
    user.update().then(() => {
        res.sendStatus(200);
    }).catch(err => {
        console.error(err);
        res.sendStatus(500);
    });
});



//DELETE method to delete a particular user based on his/her id in the database

app.delete('/users/:id', (req, res) => {
    UserModel.remove(req.params.id).then(() => {
        res.sendStatus(200);
    }).catch(err => {
        console.error(err);
        res.sendStatus(500);
    });
});