
angular.module('teste').controller('NewDisciplinaController', function ($scope, $location, locationParser, flash, DisciplinaResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.disciplina = $scope.disciplina || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The disciplina was created successfully.'});
            $location.path('/Disciplinas');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        DisciplinaResource.save($scope.disciplina, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Disciplinas");
    };
});