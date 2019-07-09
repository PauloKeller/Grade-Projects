import bottle


@bottle.route('/')
def home_page():
    mythings = ['apple', 'orange', 'peach']
    # return bottle.template('hello_world', username = 'paulo', things=mythings)
    #return bottle.template('hello_world', {'username':'paulo',
    #                                       'things': mythings})




bottle.debug(True)
bottle.run(host='localhost', port=8081)