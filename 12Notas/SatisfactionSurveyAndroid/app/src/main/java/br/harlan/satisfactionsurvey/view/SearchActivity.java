package br.harlan.satisfactionsurvey.view;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.SearchBusiness;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class SearchActivity extends BaseActivity {

    //region Variables
    private AppCompatButton btnRegister;
    private AppCompatEditText edtName;
    private AppCompatEditText edtEmail;
    private AppCompatEditText edtCompany;
    private AppCompatEditText edtTelephone;
    private AppCompatEditText edtComments;
    private AppCompatRatingBar rbKnowledge;
    private AppCompatRatingBar rbCommitment;
    private AppCompatRatingBar rbCommunication;
    private AppCompatRatingBar rbCordiality;
    //endregion Variables

    public SearchActivity() {
        super(R.layout.activity_search);
    }

    //region Methods

    //region Methods BaseActivity
    @Override
    protected void initializeComponents() {
        btnRegister = findViewById(R.id.btn_register_search);
        edtName = findViewById(R.id.edt_name_search);
        edtEmail = findViewById(R.id.edt_email_search);
        edtCompany = findViewById(R.id.edt_company_search);
        edtTelephone = findViewById(R.id.edt_telephone_search);
        edtComments = findViewById(R.id.edt_comments_search);
        rbKnowledge = findViewById(R.id.rb_knowledge_search);
        rbCommitment = findViewById(R.id.rb_commitment_search);
        rbCommunication = findViewById(R.id.rb_communication_search);
        rbCordiality = findViewById(R.id.rb_cordiality_search);
    }

    @Override
    protected void addEvents() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerEvaluation();
            }
        });
    }
    //endregion Methods BaseActivity

    private void registerEvaluation() {
        EvaluationModel evaluationModel = null;
        try {
            evaluationModel = retrieveFormData();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new SearchBusiness(messageServices, navigationServices).registerEvaluation(evaluationModel);
        }
    }

    private EvaluationModel retrieveFormData() throws Exception {
        EvaluationModel evaluationModel = new EvaluationModel();
        evaluationModel.setName(edtName.getText().toString());
        evaluationModel.setEmail(edtEmail.getText().toString());
        evaluationModel.setCompany(edtCompany.getText().toString());
        evaluationModel.setTelephone(edtTelephone.getText().toString());
        evaluationModel.setComments(edtComments.getText().toString());
        evaluationModel.setNoteKnowledge(rbKnowledge.getRating());
        evaluationModel.setNoteCommitment(rbCommitment.getRating());
        evaluationModel.setNoteCordiality(rbCordiality.getRating());
        evaluationModel.setNoteCommunication(rbCommunication.getRating());
        return evaluationModel;
    }
    //endregion Methods
}
