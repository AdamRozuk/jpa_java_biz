/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import task.jpaexample.dao.CustomerDao;
import task.jpaexample.model.CustomerDTO;

public class JpaCustomerDao extends GenericJpaDao<CustomerDTO, Long> implements CustomerDao {   
}
