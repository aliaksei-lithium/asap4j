requirejs.config({
    baseUrl: 'public/js/lib',
    paths: {
        "jquery": "jquery/jquery.min",
        "bootstrap": "bootstrap/bootstrap",
        "common-scripts" : "../common-scripts"
    },
    shim: {
        //modules
        'bootstrap': ['jquery'],

        //user scripts
        "common-scripts": {
            deps : ['jquery', 'jquery.scrollTo.min']
        },

        //jQuery plugins
        "jquery.nicescroll.min": {
            deps: ['jquery'],
            exports: 'nicescroll'
        },
        "jquery.scrollTo.min": {
            deps: ['jquery'],
            exports: 'scrollTo'
        }
    }
});