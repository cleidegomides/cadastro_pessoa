package com.everis.cadastro.exceptions.erro;

import lombok.Data;

@Data
public class PessoaNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;


    public static final class PessoaNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private PessoaNotFoundDetailsBuilder() {
        }

        public static PessoaNotFoundDetailsBuilder newBuilder() {
            return new PessoaNotFoundDetailsBuilder();
        }

        public PessoaNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PessoaNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public PessoaNotFoundDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public PessoaNotFoundDetailsBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PessoaNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public PessoaNotFoundDetails build() {
            PessoaNotFoundDetails pessoaNotFoundDetails = new PessoaNotFoundDetails();
            pessoaNotFoundDetails.setTitle(title);
            pessoaNotFoundDetails.setStatus(status);
            pessoaNotFoundDetails.setDetail(detail);
            pessoaNotFoundDetails.setTimestamp(timestamp);
            pessoaNotFoundDetails.setDeveloperMessage(developerMessage);
            return pessoaNotFoundDetails;
        }
    }
}
