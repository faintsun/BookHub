var users  = require('./controllers/users');

module.exports = function(app, passport) {

    app.post('/login', passport.authenticate('local'), function(req, res) {
        res.redirect('/user/' + req.user._id);
    });

    app.get('/user/:id', isLoggedIn, users.read);
    app.put('/user', users.create);
    app.post('/user/:id', isLoggedIn, users.update);
    app.delete('/user/:id', isLoggedIn, users.delete);

    app.post('/logout', function(req, res) {
        req.logout();
        res.end('Logged out')
    });

};

function isLoggedIn(req, res, next) {
    if (req.isAuthenticated())
        return next();

    res.end('Not logged in');
}