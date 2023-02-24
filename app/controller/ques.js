var path = require('path');
var config = require(path.join(__dirname,'..','config','config'));
var response = require(path.join(__dirname,'..','config','response'));
var questionModel = require(path.join(__dirname,'..','models','questionSchema'));

exports.createQuestion = function(req,res){
	//use this to test it locally
	// {
	//	"owner": "58c3945cbd9606388ad770fb",
	//	"problemStatement": "What is capital of Bihar ?",
	//	"choices": ["yolo","patna","mumbai","hehe"],
	//	"points": 4,
	//	"answer": 2
	// }
	if(req.body!=null){
		var newQues = new questionModel(req.body);
		newQues.save(function(error){
			if(error) res.json(response(true, error, "", ""));
			else res.json(response(false,"", "question created", newQues._id));
		});
	}
	else res.json(response(true,"Validation Error : Parameters not supplied","",""));
};

exports.getQuestion = function(req,res){
	var quesId = req.query.quesId;
	if(quesId == null){
		questionModel.find({}, function(err,docs){
			if(err) res.json(response(true,err,"",""));
			else	res.json(response(false,"","success",docs));
		});
	}
	else{
		questionModel.findOne({_id:quesId}, function(err,docs){
			if(err) res.json(response(true,err,"",""));
			else	res.json(response(false,"","success",docs));
		});
	}
};

exports.updateQuestion = function(req,res){
	var quesId = req.query.quesId;
	if(quesId!=null && req.body!=null){
		questionModel.updateOne({_id:quesId}, req.body,function(err){
			if(err) res.json(response(true,err,"",""));
			else res.json(response(false,"", "question updated", ""));
		});
	}
	else res.json(response(true,"Validation Error : Parameters not supplied","",""));
};

exports.deleteQuestion = function(req,res){
	var quesId = req.query.quesId;
	if(quesId!=null){
		questionModel.deleteOne({_id:quesId},function(err){
			if(err)	res.json(response(true,err,"",""));
			else	res.json(response(false,"","question deleted",""));
		});
	}
	else res.json(response(true,"Validation Error : Parameters not supplied","",""));
};
