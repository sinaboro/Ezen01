console.log('Relpy Module....')

var replyService = ( function() {

    function add(reply, callback, error){
        console.log("add reply2.............");

        $.ajax({
            type : 'post' ,                  
            url : '/replies/new',       
            data : JSON.stringify(reply),
            contentType : "application/json; charset = utf-8",
            success : function( result, status, xhr){
                if(callback){                 
                    callback(result);
                }
            },
            error : function( xhr, status,err){
                if(error){
                    error(err);
                }
            }
        });
     } // end for add
    
    function getList(param, callback, error){
        var bno = param.bno;
        var page = param.page || 1;

        $.getJSON("/replies/pages/" + bno + "/" + page + ".json" ,
            function(data){
                if(callback) {
                    callback(data);
                }

            }).fail(function(xhr, status, err){
                if(error) {
                    error(err);
                }
            });
    } //end for getList

    function remove(rno, callback, error){
            $.ajax({
                type : 'delete',
                url : '/replies/' + rno,
                success : function( deleteResult, status, xhr){
                    if(callback) callback(deleteResult);
                },
                error : function( xhr, status, err){
                    if(error) error(err);
                }
            });
    }  // end for remove

    function update(reply, callback, error){
            console.log("update............");

            $.ajax({
                type : 'put',
                url :  '/replies/'  + reply.rno,
                data : JSON.stringify(reply),
                contentType : "application/json; charset=utf-8",
                success : function(result, status, xhr){
                    if(callback){
                        callback(result);
                    }
                },
                error : function( xhr, status, err){
                    if(error){
                        error(err);
                    }
                }
            });
    } //end for update

    function get(rno, callback, error){
        console.log("get............");

        // $.ajax({
        //     type : 'get',
        //     url :  '/replies/get/'  + rno,
        //     success : function(result, status, xhr){
        //         if(callback){
        //             callback(result);
        //         }
        //     },
        //     error : function( xhr, status, err){
        //         if(error){
        //             error(err);
        //         }
        //     }
        // });
        $.get("/replies/get/" + rno +  ".json" ,
            function(data){
                if(callback) {
                    callback(data);
                }

            }).fail(function(xhr, status, err){
                if(error) {
                    error(err);
                }
            });
    } // end for get

    return {
    	add : add,
        getList : getList,
        remove : remove,
        update : update,
        get : get
    };  

})();