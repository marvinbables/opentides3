/*
 * NinjaDaoJpaImpl.java
 */
package org.opentides.dao.impl;

import org.opentides.bean.Ninja;
import org.opentides.dao.NinjaDao;
import org.springframework.stereotype.Repository;
import org.opentides.dao.impl.BaseEntityDaoJpaImpl;
  

/**
 * This is the dao implementation for Ninja.
 * Scaffold generated by opentides3 on Oct 26, 2014 10:59:57. 
 * @author opentides
 */
@Repository(value="ninjaDao")
public class NinjaDaoJpaImpl extends BaseEntityDaoJpaImpl<Ninja, Long>
		implements NinjaDao {

}