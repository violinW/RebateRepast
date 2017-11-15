-- -----------------------------------------------------
-- Table `RebateRepast`.`BusinessDistrict`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RebateRepast`.`BusinessDistrict`;
CREATE TABLE IF NOT EXISTS `RebateRepast`.`BusinessDistrict` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(45) UNIQUE NOT NULL,
  `bd_name` VARCHAR(45) NOT NULL COMMENT '商圈名称',
  `bd_abstract` VARCHAR(45) COMMENT '商圈介绍',
  `createdOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`, `UUID`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '商圈表';

-- -----------------------------------------------------
-- Table `RebateRepast`.`BDShop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RebateRepast`.`BDShop`;
CREATE TABLE IF NOT EXISTS `RebateRepast`.`BDShop` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(45) UNIQUE NOT NULL,
  `BD_UUID` VARCHAR(45) NOT NULL COMMENT '所属商圈UUID',
  `shop_name` VARCHAR(45) NOT NULL COMMENT '店铺名称',
  `shop_abstract` VARCHAR(45) COMMENT '店铺简介',
  `shop_account` VARCHAR(45) NOT NULL COMMENT '店铺支付宝账户',
  `shop_address` VARCHAR(45) NOT NULL COMMENT '店铺地址',
  `shop_phone` VARCHAR(45) NOT NULL COMMENT '联系电话',
  `updatedOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT ' 更新时间',
  `createdOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`, `UUID`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '合作店铺表';


-- -----------------------------------------------------
-- Table `RebateRepast`.`DBOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RebateRepast`.`DBOrder`;
CREATE TABLE IF NOT EXISTS `RebateRepast`.`DBOrder` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(45) UNIQUE NOT NULL,
  `member_UUID` VARCHAR(45) NOT NULL COMMENT '会员UUID',
  `shop_UUID` VARCHAR(45) NOT NULL COMMENT '店铺UUID',
  `amount` VARCHAR(45) NOT NULL COMMENT '金额',
  `shop_abstract` VARCHAR(45) COMMENT '店铺简介',
  `shop_account` VARCHAR(45) NOT NULL COMMENT '店铺支付宝账户',
  `shop_address` VARCHAR(45) NOT NULL COMMENT '店铺地址',
  `shop_phone` VARCHAR(45) NOT NULL COMMENT '联系电话',
  `createdOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`, `UUID`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '订单表';

-- -----------------------------------------------------
-- Table `RebateRepast`.`BDMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RebateRepast`.`BDMember`;
CREATE TABLE IF NOT EXISTS `RebateRepast`.`BDMember` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(45) UNIQUE NOT NULL,
  `BD_UUID` VARCHAR(45) NOT NULL COMMENT '会员注册商圈UUID',
  `name` VARCHAR(45) NOT NULL COMMENT '名称',
  `phone` VARCHAR(45) NOT NULL COMMENT '电话',
  `sex` VARCHAR(45) NOT NULL COMMENT '性别',
  `deleted` BOOLEAN NOT NULL DEFAULT False COMMENT '是否删除',
  `yunpay_account` VARCHAR(45) NOT NULL COMMENT '云付通账号',
  `self_recommend` BOOLEAN NOT NULL COMMENT '是否以我为推荐人',
  `Recommended_account` VARCHAR(45) COMMENT '推荐人账号',
  `createdOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`, `UUID`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '会员表';

-- -----------------------------------------------------
-- Table `RebateRepast`.`BDRecharge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RebateRepast`.`BDRecharge`;
CREATE TABLE IF NOT EXISTS `RebateRepast`.`BDRecharge` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(45) UNIQUE NOT NULL,
  `member_UUID` VARCHAR(45) NOT NULL COMMENT '充值会员UUID',
  `amount` VARCHAR(45) NOT NULL COMMENT '充值金额',
  `createdOn` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  PRIMARY KEY (`id`, `UUID`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '会员充值表';

