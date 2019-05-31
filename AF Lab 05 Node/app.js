//Question 01
//Hello world

console.log('Hello World');  //prints 'Hello World'

//Question 02
//Use OS system library

const os = require('os');

console.log('Architecture ' + os.arch());  //prints 'Architecture x64'
console.log('CPUs ' + os.cpus().length);   //prints 'CPUs 4'
console.log('OS ' + os.platform());        //prints OS 'linux'

//Question 03
//Read a file

const fs = require('fs');
const fileName = __dirname + '/test.txt';

fs.readFile(fileName, (err, data) => {
    if(err){
        console.error(err);
    }

    console.log(data.toString());   //prints '//Question 03 //Read a file NodeJS is awesome'

});

    //without toString()
    console.log(data);   //prints '<Buffer 2f 2f 51 75 65 73 74 69 6f 6e 20 30 33 0a 2f 2f 52 65 61 64 20 61 20 66 69 6c 65 0a 0a 4e 6f 64 65 4a 53 20 69 73 20 61 77 65 73 6f 6d 65>'


    //printing the value of data without toString method.
    //The data argument to the callback contains the full contents of the file represented as a string in utf8 format.
    // If we omit the utf8 argument completely, then the method will just return the raw contents in a Buffer object.
    // Removing the utf8 argument in the above code

    try{
        var data = fs.readFileSync('test.txt', 'utf8');
        console.log(data);
    }catch(e){
        console.log('Error', e.stack);
    }


    const data1 = fs.readFileSync(fileName);
    console.log(data1.toString());   //prints '//Question 03 //Read a file NodeJS is awesome'


//Question 04
//Use streams to copy content of a file

const fileName1 = __dirname + '/test.txt';   //source file
const outFileName = __dirname + '/test-copy.txt';   ///destination file


const readStream = fs.createReadStream(fileName1);  //create read stream from the source
const writeStream = fs.createWriteStream(outFileName);   //create write stream from the destination


//pipe the read stream to write the stream
readStream.pipe(writeStream);


readStream.on('data', data => {
    console.log(data.toString());      //prints '//Question 03 //Read a file NodeJS is awesome'
});


//Question 05
//Http Server

//adding a post request that accepts form field name and return html with Hello {name}

const http = require('http');

http.createServer((req, res) => {
  res.setHeader('Content-Type', 'text/html');

  switch(req.method) {
      case 'GET':
          res.write('<h1>Hello World</h1>');
          res.end();
          break;

      case 'POST':
          req.on('data', data => {

              res.write('<h1>Hello ' + data + '</h1>');
              res.end();
          });
          break;
  }

}).listen(3000, (err) => {
    console.log('Server is listening tp port 3000')
});







