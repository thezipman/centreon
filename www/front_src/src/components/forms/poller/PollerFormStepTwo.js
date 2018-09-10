import React, { Component } from "react";
import { Field, reduxForm as connectForm } from "redux-form";
import SelectField from "../../form-fields/SelectField";
import CheckboxField from "../../form-fields/CheckboxField";

import { selectRemoteServerValidator } from "../../../helpers/validators";

class PollerFormStepTwo extends Component {
  render() {
    const { error, handleSubmit, onSubmit, submitting, pollers } = this.props;
    return (
      <div className="form-wrapper">
        <div className="form-inner">
          <div className="form-heading">
            <h2 className="form-title">Server Configuration</h2>
          </div>
          <form autocomplete="off" onSubmit={handleSubmit(onSubmit)}>
            {pollers ? (
              <Field
                name="linked_remote"
                component={SelectField}
                label="Select linked Remote Server:"
                options={[
                  {
                    disabled: true,
                    selected: true,
                    text: "Select Remote Server",
                    value: ""
                  }
                ].concat(
                  pollers.items.map(c => ({ value: c.id, label: c.text }))
                )}
              />
            ) : null}
            <Field
              name="manage_broker_config"
              component={CheckboxField}
              label="Centreon must connect to poller to open Broker flow"
            />
            <div class="form-buttons">
              <button className="button" type="submit">
                Apply
              </button>
            </div>
            {error ? <div class="error-block">{error.message}</div> : null}
          </form>
        </div>
      </div>
    );
  }
}

const validate = () => ({});

export default connectForm({
  form: "PollerFormStepTwo",
  validate,
  warn: () => {},
  enableReinitialize: true
})(PollerFormStepTwo);