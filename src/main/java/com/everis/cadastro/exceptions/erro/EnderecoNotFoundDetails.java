package com.everis.cadastro.exceptions.erro;

import lombok.Data;

@Data
public class EnderecoNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;


    public static final class EnderecoNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private EnderecoNotFoundDetailsBuilder() {
        }

        public static EnderecoNotFoundDetailsBuilder newBuilder() {
            return new EnderecoNotFoundDetailsBuilder();
        }

        public EnderecoNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public EnderecoNotFoundDetails build() {
            EnderecoNotFoundDetails enderecoNotFoundDetails = new EnderecoNotFoundDetails();
            enderecoNotFoundDetails.setTitle(title);
            enderecoNotFoundDetails.setStatus(status);
            enderecoNotFoundDetails.setDetail(detail);
            enderecoNotFoundDetails.setTimestamp(timestamp);
            enderecoNotFoundDetails.setDeveloperMessage(developerMessage);
            return enderecoNotFoundDetails;
        }
    }
}
