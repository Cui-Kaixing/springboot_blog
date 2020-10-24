/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : springboot_blog

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-10-25 00:54:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `views` int(11) DEFAULT NULL,
  `commentabled` int(11) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('41', '2', null, '优美文章', '   人生风雨，有些记忆可以散去，人生不堪回首，有些事情不要再提，人生经历，磨砺着痛惜，人生不易，懂得放过自己，一切都会过去。--题记\r\n\r\n　　浅淡人生，岁月的痕迹，我们一路走，一路感悟了着人生风雨，新的、旧的、来的、去的，不断上演，也不断错过，远了、近了、天涯也咫尺，始料不及也匆匆逝去。\r\n\r\n　　涉世红尘，谁能没有悲喜，人间行走，谁能没有得失，来来去去，风风雨雨，谁能没有挫折和委屈，岁月无情，将生活碾转成泥，时光寂寥，也有很多事情让我们承担不起，不得不学着放弃。\r\n\r\n　　千般过往，万般事物中，最应该放弃的就是放过自己，不让自己心智沉迷，不让自己顾此失彼，不要让自己疏远了心与灵魂的距离，不要让自己没有了享受快乐的精力。\r\n\r\n　　懂得放过自己，不让自己再匆忙的去追赶名利，慢下来，将自己的生命静静的梳理；懂得放过自己，不让自己的生活在繁忙中迷离，澄澈清晰，用智慧解开人生的秘密；懂得放过自己，坦然接受各种幸福和快乐，也面对各种忧伤和别离，尽情的将生命的过程自由的演绎，也就有了更多的乐趣。\r\n\r\n　　懂得放过自己，其实就是接纳了自己，与其让命运牵着我们的鼻子走，跟着无奈的潮水涌动，真不如放过自己，任生命自由自在的游弋，或许，我们会有更广阔的天地。\r\n\r\n　　人间事物，是是非非，人生命运，隐隐回回，谁能看的透彻，谁又能说的清楚，谁能理的明晰？\r\n\r\n　　在苦涩人生里，懂得放过自己，也许哭着哭着就笑了；在坎坷人生里，懂得放过自己，也许痛着痛着就好了；在迷茫世界里，懂得放过自己，也许熬着熬着就活明白了；在无常的世界里，懂得放过自己，也许那些残酷的记忆，都会变成回忆。\r\n\r\n　　懂得放过自己，实际是对自己的一种爱，放下利欲熏心的负累，放弃疲于奔命的追随，放松生命的苦累，在打破枷锁的一刻，那也是对生命的一种爱的回归。\r\n\r\n　　懂得放过自己，实际是对自己人生的一次赎罪，对自己的无知，对自己的愚昧，不能正确面对自己的痴心妄念，直到让心蒙上了灰，才懂得后悔。\r\n\r\n　　懂得放过自己，就是给了自己一片安静的天空，抛弃繁华，简单生活，为自己而活，对自己的欲望负责，不要徒劳无益的为虚伪活着。\r\n\r\n　　生命的脆弱，也经不起世事太多的炙热，懂得临渊而思，懂得适可而止，平凡着，简单着，也好过人生一辈子得不到解脱。\r\n\r\n　　懂得放过自己，也就真正的找到了自我，这不是逃避，而是让自己更自由的生活；这不是堕落，而是不让自己的生命匆忙的在这个世界走过；更不是退缩，而是让灵魂更加的鲜活。\r\n\r\n　　这一份懂得，虽然不能将幸福和美好定格，但是，懂得放过自己，打开桎梏，放下累赘，却是人生智慧的浓缩，也还原了生命的本质。\r\n\r\n　　人生本就是一场选择的角逐，我选择放过自己。', '6', '1', '2020-10-24');
INSERT INTO `blog` VALUES ('42', '2', null, '孤独', '走进乡村就是走进孤独——就是走进了绿色的孤独里。满眼满眼的绿，很是杂乱潦草，荒芜的田园、庭院，蒿草密布，荆棘丛生，不安分的记忆总是把一些往事留下来。记忆还在旧日的野地里和童伴一起打滚，在山坳里追赶洁白如花的羊群，在旷野里吼一吼自编自唱的山歌，在刺骨的清泉里摸一回鱼虾，游一回泳，再让父母在嫩嫩的背脊上留几条笤帚花儿。那些不安分的记忆帮你念叨着过去如何如何的好。儿时的乡村在云雾里，今天的乡村却在孤独里，你本来很是轻松的心却来了一丝不够彻底的惆怅，也来了一丝道不清的暖暖的幸福，你的感情世界里莫名地生出了些非分之想。此时此刻的你，只想找一片绿叶，很深情的绿叶，躺在那上面睡一会儿，安安静静地，把世俗抛到九霄云外的另一个宇宙。这些时间里，你就圣洁得如同拌豆腐的葱儿，若大的舞台里，空落落的只有你，世界给你一只葫芦你只想画一只葫芦。你不怕孤独，你就是野花上的那只孤独无猜的蝶儿，你就是那乔木头顶上无影无踪的风儿，你就是那彩虹底下那朵烂漫天真的花儿……世界牢牢挣在你的手心里，一切无精打采的藤滕曼曼，一切荒荒芜芜的蓼草，因为有你的多情，都鲜活起来，一起随你孤独的舞蹈而舞蹈。风景不再是在人们刻意打扮的花园里，不再是在人头攒动的十字街头里，不再是在翩翩起舞的喧嚣舞池里，就在绿色给生命和你带来感动的那一刹那倾里。\r\n\r\n　　这个季节是属于生命的，但是播种者却是寥寥几位老者。是谁导演了这场戏呀，是外面疯狂的世界吧，那洋房，那豪车，那票子……如此城市化、城镇化算不算上厕所也需结伴而行呢？无人村相继出现，失语的村庄里谁是最后的舞者？难道孕育生命的村庄，难道播种生命的村庄就这样慢慢退出人文的舞台吗？按生活的需求，我们太多地屈从安逸的安排了。哪一天，我们退化的肢体，还能否委以舞蹈的重任，我真的很是怀疑！\r\n\r\n　　我虽然很不诗情画意，但是村庄让我的感情投入太彻底，尽管她荒芜的不堪入目，我还是能从一块破败的砖，一口碎裂的瓦里找到爱她的千万个理由来。在那总是敞开的窗儿，我能找到古老的唐诗；从厚厚的青苔里，找回儒雅的歌赋；从挂着月儿的柳梢里，读到婉转的宋词……我不需言辞，只用一个一个符号，就足以表达我与故乡深深的情结。故乡在这个世界里等了我几千年，而我却只能陪她几十年，故乡的伟大使我真的深感愧疚。康熙大帝为了眷顾他的江山，要向苍天再借五百年，我为了我的故乡，只向苍天借个五十年，你不会笑我五十步笑百步吧！\r\n\r\n　　在文字里爬行，就是千年的孤独，这说法也许不算过分。有几个在文字里舞蹈的不是孤独者呢？文字没法和歌唱比，文字没法和字画古玩比，文字没法和房子比，文字没法和车子比，文字更没法和票子比。歌唱者总是在舞台上想办法扮酷，把本来的平头留一个辫子就成了艺术家了，把吃饭的一双筷子故意弄丢一只，就是指挥家了，让眼睛迷离的人们拜倒在石榴裙下，奉上鲜花，抛洒尖叫，掷出掌声，让世界在醉生梦死里，纸醉金迷里不知归途。字画原本也是白纸一张，通过人们舌尖的打磨，在唾沫星的口水战里就成了古董，当成了价值连城文物时，大凡枪手早已作古了。房子能住，文字能吗？车子能坐，文字能吗？票子能用，文字能吗？因为文字是无私的，所以，爱上文字，就是爱上孤独，爱上贫穷，文学者就是孤独的舞者。(www.lz13.cn)\r\n\r\n　　祖辈们开辟出来的家园里，上演过多少相聚和别离，而现在故事在城外，故人却在城内。守望着祖辈们培育的傲岸古木，我丢失了笑脸，忘记了对白。我已经破茧成蝶，谁愿意与我双飞呢？尽管在村庄里飞多远飞多久都不会累，你却选择别离。虽然旅途太累太累，你却一路飞去不回。只剩下一片叶儿在坚守一株高大的乔木，季节告诉人们马上就是严酷的冬天了。如果春天又来，你会成为那只寻旧垒的燕子吗？答案在天之涯，还是地之角？我只是村庄里的那只不会迁徙的麻雀，无论春夏秋冬，都在故乡的屋檐孤独的舞蹈，孤独的歌唱；我只是家乡里的一块石头，孤独地守候着那麦穗一茬一茬地成长，守候着那映有着云彩的荷塘，守候着那一轮不离不弃的月亮；我只是乡土里的一颗种子，在泥土里孤独的舞蹈，我会孤独的发芽，孤独的开花，孤独的死去……请你不要在我面前谈志向，谈抱负，我只想跟你谈知交，谈深情……\r\n\r\n　　把我从此忘了吧，我不需要多情的安慰，不管谎言多美，对一个孤独的舞者你付出再多也许是枉然。我爱的会爱，我想的会想，我给的会给，如果你真的爱我，请先爱我的乡土吧……\r\n\r\n', '4', '1', '2020-10-21');

-- ----------------------------
-- Table structure for `blog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogid` int(11) DEFAULT NULL,
  `tagid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blogid` (`blogid`),
  KEY `tagid` (`tagid`),
  CONSTRAINT `blog_tag_ibfk_1` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`),
  CONSTRAINT `blog_tag_ibfk_2` FOREIGN KEY (`tagid`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('61', '41', '12');
INSERT INTO `blog_tag` VALUES ('62', '42', '12');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('12', '人生哲言');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('2', '随笔');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nikename` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '你就是根号四', 'ckx', '733ec8801983e81f8c729a9bef2c8689', '1291407533@qq.com', '1', '2020-09-25 16:23:05');
