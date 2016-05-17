

angular.module('teste').controller('EditDisciplinaController', function($scope, $routeParams, $location, flash, DisciplinaResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.disciplina = new DisciplinaResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The disciplina could not be found.'});
            $location.path("/Disciplinas");
        };
        DisciplinaResource.get({DisciplinaId:$routeParams.DisciplinaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.disciplina);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The disciplina was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.disciplina.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Disciplinas");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The disciplina was deleted.'});
            $location.path("/Disciplinas");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.disciplina.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});