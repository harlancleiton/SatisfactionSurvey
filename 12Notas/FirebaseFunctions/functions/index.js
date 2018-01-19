const functions = require('firebase-functions');
const admin = require('firebase-admin');

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });
exports.countTotal = functions.database.ref('evaluations/{pushId}/').onWrite(event => {
    var evaluation = event.data.val()
    console.log(evaluation)
    if(evaluation.counted) {
        return
    }
    evaluation.counted = true
    var myRef = admin.initializeApp(functions.config().firebase).database().ref()
    console.log(myRef)
    var statisticsChild = myRef.child('statistics')
    var total
    var aux = statisticsChild.child('total').once('value').then(function(snapshot) {
        total = snapshot.val()
    })
    var updates = {}
    updates[statisticsChild + '/total']
    myRef.child('statistics').child('total').set(total+1)
    statisticsChild.child('total').update(updates)
    return event.data.ref.set(evaluation)
});