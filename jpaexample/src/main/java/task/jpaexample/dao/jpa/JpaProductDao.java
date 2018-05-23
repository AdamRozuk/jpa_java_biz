/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import task.jpaexample.dao.ProductDao;
import task.jpaexample.model.ProductDTO;

public class JpaProductDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
}
