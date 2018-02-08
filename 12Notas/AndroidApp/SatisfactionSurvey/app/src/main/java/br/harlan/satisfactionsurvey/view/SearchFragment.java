package br.harlan.satisfactionsurvey.view;


import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.harlan.satisfactionsurvey.R;
import br.harlan.satisfactionsurvey.business.EvaluationBusiness;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class SearchFragment extends BaseFragment {

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
    private AppCompatRadioButton rbSatisfied;
    private AppCompatRadioButton rbIndifferent;
    private AppCompatRadioButton rbDissatisfied;
    private AppCompatSpinner spnTypeEvaluation;
    SimpleMaskFormatter simpleMaskFormatter;
    MaskTextWatcher maskTextWatcher;
    //endregion Variables

    public SearchFragment() {
        super(R.layout.fragment_search);
    }

    //region Methods

    //region Methods BaseActivity
    @Override
    protected void initializeComponents(View rootView) {
        btnRegister = viewRoot.findViewById(R.id.btn_register_search);
        edtName = viewRoot.findViewById(R.id.edt_name_search);
        edtEmail = viewRoot.findViewById(R.id.edt_email_search);
        edtCompany = viewRoot.findViewById(R.id.edt_company_search);
        edtTelephone = viewRoot.findViewById(R.id.edt_telephone_search);
        edtComments = viewRoot.findViewById(R.id.edt_comments_search);
        rbKnowledge = viewRoot.findViewById(R.id.rb_knowledge_search);
        rbCommitment = viewRoot.findViewById(R.id.rb_commitment_search);
        rbCommunication = viewRoot.findViewById(R.id.rb_communication_search);
        rbCordiality = viewRoot.findViewById(R.id.rb_cordiality_search);
        rbSatisfied = viewRoot.findViewById(R.id.rb_satisfied_search);
        rbIndifferent = viewRoot.findViewById(R.id.rb_indifferent_search);
        rbDissatisfied = viewRoot.findViewById(R.id.rb_dissatisfied_search);
        spnTypeEvaluation = viewRoot.findViewById(R.id.spn_type_comment);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.types_evaluation_array, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTypeEvaluation.setAdapter(arrayAdapter);
        simpleMaskFormatter = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        maskTextWatcher = new MaskTextWatcher(edtTelephone, simpleMaskFormatter);
    }

    @Override
    protected void addEvents() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerEvaluation();
            }
        });
        edtTelephone.addTextChangedListener(maskTextWatcher);
    }
    //endregion Methods BaseActivity

    private void registerEvaluation() {
        EvaluationModel evaluationModel = null;
        try {
            evaluationModel = retrieveFormData();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new EvaluationBusiness(messageServices, navigationServices).registerEvaluation(evaluationModel);
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
        String type = spnTypeEvaluation.getSelectedItem().toString();
        switch (type) {
            case "Elogio":
                evaluationModel.setTypeEvaluation(EvaluationModel.EVALUATION_TYPE_COMPLIMENT);
                break;
            case "Dúvida":
                evaluationModel.setTypeEvaluation(EvaluationModel.EVALUATION_TYPE_DOUBT);
                break;
            case "Crítica":
                evaluationModel.setTypeEvaluation(EvaluationModel.EVALUATION_TYPE_CRITICISM);
                break;
            case "Sugestão":
                evaluationModel.setTypeEvaluation(EvaluationModel.EVALUATION_TYPE_SUGGESTION);
                break;
            default:
                evaluationModel.setTypeEvaluation(EvaluationModel.NO_SELECTION);
        }
        if (rbDissatisfied.isChecked())
            evaluationModel.setSatisfaction(EvaluationModel.DISSATISFIED);
        else if (rbIndifferent.isChecked())
            evaluationModel.setSatisfaction(EvaluationModel.INDIFFERENT);
        else if (rbSatisfied.isChecked())
            evaluationModel.setSatisfaction(EvaluationModel.SATISFIED);
        else
            evaluationModel.setSatisfaction(EvaluationModel.NO_SELECTION);
        return evaluationModel;
    }
    //endregion Methods
}