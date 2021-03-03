package ru.manager.manager;

import lombok.Data;
import ru.manager.domain.Issue;
import ru.manager.repository.RepositoryIssueList;
;

    @Data
    public class ManagerIssue {
        private RepositoryIssueList repository;


        public ManagerIssue(RepositoryIssueList repository) {
            this.repository = repository;
        }

//        public Issue[] searchBy(String text) {
//            Issue[] result = new Issue[0];
//            for (Issue issue: repository.findAll()) {
//                if (matches(issue, text)) {
//                    Issue[] tmp = new Issue[result.length + 1];
//                    System.arraycopy(result, 0, tmp, 0, result.length);
//                    tmp[tmp.length - 1] = issue;
//                    result = tmp;
//                }
//            }
//            return result;
//        }

        public void matches(Issue issue, String search) {

        }

}
