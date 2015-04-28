-- phpMyAdmin SQL Dump
-- version 4.0.10.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 28, 2015 at 09:33 AM
-- Server version: 5.5.42-cll
-- PHP Version: 5.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nbii_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `advert`
--

CREATE TABLE IF NOT EXISTS `advert` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `client_id` smallint(6) NOT NULL,
  `user_id` smallint(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `pic` varchar(20) DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `name` varchar(100) NOT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `album_id` smallint(6) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `expiry` date DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `sub_expiry` date DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `coor_id` smallint(6) NOT NULL,
  `album_id` smallint(6) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `venue` varchar(100) NOT NULL,
  `e_date` date NOT NULL,
  `e_time` varchar(15) DEFAULT NULL,
  `fee` varchar(10) DEFAULT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `attach` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `rating` varchar(30) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `event_comment`
--

CREATE TABLE IF NOT EXISTS `event_comment` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `event_log`
--

CREATE TABLE IF NOT EXISTS `event_log` (
  `id` mediumint(9) NOT NULL,
  `user_id` smallint(6) NOT NULL,
  `log_event` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `event_reply`
--

CREATE TABLE IF NOT EXISTS `event_reply` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `event_comment_id` mediumint(9) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `album_id` smallint(6) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `expiry` date DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `user_id`, `album_id`, `title`, `content`, `expiry`, `date_added`) VALUES
(12, 1, NULL, 'SEACOM appoints new CEO', 'SEACOM has revealed the appointment of Byron Clatterbuck as its Chief Executive Officer (CEO). According to the company, Clatterbuck is an industry veteran with more than 18 years experience in the global telecommunications industry. He has held a number of senior international executive positions during his career, focusing mostly on rapidly developing markets around the world.\r\n\r\nClatterbuck joined SEACOM in 2012 as Chief Commercial Officer with responsibility for driving revenue growth from African and global service provider customers and partners. Prior to this, Clatterbuck was the President of Tata Communications’ global service provider segment, a company operating the largest private subsea cable system network in the world. Prior to that, he  held senior executive positions at BT, Level 3, and REACH.\r\n\r\nBrian Herlihy, SEACOM’s founder and executive director, said “SEACOM has changed the African ICT landscape and it is now time for us to continue this transformation by driving new services and capabilities into Africa’s marketplace. Clatterbuck will lead SEACOM into a new era of growth and leverage his operational and business development know-how to unleash the power and speed of SEACOM’s global network.”\r\n\r\n“Africa is poised to be a key new growth driver for the global economy, and the development story of this decade, and I am pleased to have the opportunity to lend my international skills and experience to a developing company like SEACOM.  Moreover, SEACOM has a solid global reputation for innovation, integrity and quality, and I look forward to leading the great team here during such an important time in SEACOM’s and Africa’s development”, said Clatterbuck on his appointment.', '2015-04-30', '2015-02-08 22:00:00'),
(13, 1, NULL, 'IFC set to grow Mobile Money usage in Uganda', 'Cignifi has inked an agreement with the International Finance Corporation (IFC), which is aimed at expanding the delivery and usage of mobile financial services in Uganda.\r\n\r\nCignifi will be working with the IFC to help drive the adoption and growth of Airtel Uganda’s Mobile Money platform, an e-commerce service that enables customers to use their mobile phones to send and receive money, make payments, make withdrawals from ATMs, check bank balances, deposit money from a phone, and conduct other banking functions.\r\n\r\nGreta Bull, IFC Manager, Financial Institutions Group Advisory Services Sub-Saharan Africa, stated that: “Data analytics potentially offers great insights for the development of innovative products and services to extend financial inclusion in Sub-Saharan Africa. IFC is excited to be working together with Cignifi and Airtel Uganda to further explore and enhance this area of research.”\r\n\r\nCignifi will use its proprietary data platform to analyse Airtel call detail records and Airtel Money transactions. Cignifi will score Airtel customers based on their propensity to use Airtel Money. The objective will be to identify prospective users that have not yet registered for the service and also to reactivate users that have registered but are currently dormant. The analysis is designed to yield a more effective, better-targeted way to market mobile money products.\r\n\r\nJonathan Hakim, CEO of Cignifi added: “We are excited to be working with Airtel and the IFC on their initiative to accelerate delivery of financial services in sub-Saharan Africa. Our selection from an extremely competitive field is recognition of Cignifi’s unique expertise in managing and analyzing huge mobile datasets. We will apply our behavioral analytics to help Airtel ramp up adoption of its mobile financial services in Uganda.”', '2015-04-30', '2015-02-04 22:00:00'),
(14, 1, NULL, 'He who connects wins – SAP Africa CEO', 'In this brave new world of the Networked Economy, one adage rings truer than ever: no company is an island. Mobile, cloud, social media and machine-to-machine (M2M) technologies are creating connections between people and organisations in more ways than we have ever seen – and these smarter, faster and more global networks are already starting to transform business in ways never thought possible.\r\n\r\nHow, you ask skeptically. Simple. Today’s business world demands significant interaction with suppliers, trading partners, stakeholders and customers – but many of those interactions still rely on inefficient technologies like phone, e-mail, and so on. What’s more, those connections tend to be with people and organisations you’re already connected to, limiting the potential value.\r\n\r\nToday’s Networked Economy offers opportunities for connecting to a much broader set of parties, in much more effective ways. In addition to personal contacts, today’s networks bring together current and potential suppliers, partners, and customers across both the financial and physical value chains. And increasingly they include machine-to-machine sensors and devices.\r\n\r\nBut the real power of networks lies in what goes on inside them – all the interactions, transactions and commentary, and the massive amounts of insights and data that they generate. Companies that move beyond simple transactions and tap into these insights and data are finding they can drive real competitive advantage. If you’re entering a new market, how do you evaluate risk? How do you determine what products suit local tastes? You have your own experts and market data, but your networks of suppliers, partners, and customers may hold much more valuable knowledge.\r\n\r\nIn the past, companies relied on one-to-one business networks, establishing a direct link between both parties. Networks were all about connecting companies more efficiently to perform a specific process like buying, selling or invoicing.\r\n\r\nToday, buyers and sellers are using networks to enhance and expand their relationships, and use many-to-many approaches that build large communities, make new contacts, share knowledge, conduct transactions, and much more. Buyers are using the connectivity and insights of networks to find the right partners and optimise their spend and supply chain. Sellers are using networks to engage with customers when, how and where they want to be engaged to increase satisfaction and wallet share.\r\n\r\nThis isn’t some futuristic crystal ball-gazing. It’s here and now. Social tools and business networks have already changed the nature of business and engagement. Companies today are already more connected and mobile than ever. The opportunity now is to use this greater level of connectedness to enable new processes that are only possible in a networked environment, and drive innovation across their operations.\r\n\r\nWhat’s this means is that the use of business networks and social enterprise software is becoming a competitive differentiator. We’re already seeing growing numbers of South African businesses harnessing the insights and intelligence of entire communities to enable new processes that drive innovation and competitive advantage.\r\n\r\nI would go so far as to say that businesses can no longer be competitive without the support of a network – and the convergence of trends like the growing use of cloud computing, the advancements of machine-to-machine technology, and the evolution of the technology powering the supply chain are leaving companies with no other choice.\r\n\r\nIt’s not a terrible option to be left with, however, as companies that connect and collaborate through networks outperform their peers. McKinsey and Company reports that networked enterprises are 50% more likely than their peers to have increased sales, higher profit margins, gain market share, and be a market leader.\r\n\r\nThey are also getting closer to their customers, transforming both innovation and customer relationships. Just as consumers tap into personal networks to learn, share and shop better, companies will tap the ‘knowledge of crowds’ and insights from business networks to not only sense the present, but see the future and proactively shape it to their advantage by anticipating risks and trends in the market, and delivering the products and services that drive higher sales and greater market share.\r\n\r\nThe combination of business networks and social platforms is a game-changer – and we’re just getting started. There’s no doubt that the Networked Economy will have a profound impact on our future.\r\n\r\nBy Pfungwa Serima, CEO of SAP Africa', '2015-04-30', '2015-02-02 22:00:00'),
(15, 1, NULL, 'Video Interview: “Africa’s mobile future is exciting” – Brett Loubser', 'IT News Africa caught up with Brett Loubser, WeChat’s head of Africa, at the Tech4Africa conference – which was held at the Sci Bono Centre in Johannesburg.\r\n\r\nRecently, IT News Africa also spoke to Gareth Knight, creator of Tech4Africa in order to discuss the concept of the USD $50 smartphone as well as its impact on Africa. Knight also listed the Top 10 benefits of the $50 smartphone in Africa, which can be viewed here.\r\n\r\nAt the event, Loubser discussed the following topics with IT News Africa:\r\n\r\n- The evolution of social.\r\n\r\n- The fact that WeChat is designed to work in concert with its users and become a point of connection and control for their entire lives – both on and offline.\r\n\r\n- The importance of making value-added services available to users and businesses alike, to ensure they receive a differentiated social experience.\r\n\r\n- The future of mobile in Africa.\r\n\r\nDarryl Linington', '2015-04-30', '2014-10-13 22:00:00'),
(16, 1, NULL, 'Mobile is revolutionising business in Africa', 'Twinpine Network held its #KuunganaKE event at the Intercontinental Hotel in Nairobi recently. The event highlighted the opportunities for businesses through the mobile web.\r\n\r\nElo Umeh, Chief Executive Officer and Founder, Twinpine Network, in his opening remarks emphasised the role of innovation and creativity in the business world, “The entire African economy is going through a revolution and businesses have begun to seek for better ways to market their products and connect with their customers. Today’s Marketing is mobile and mobile advertising has become a key driver of businesses in Africa.”\r\n\r\nRegional Manager, East Africa, Thomas Mbalu, who gave a presentation on the event’s theme ‘Discovering the Mobile Web in Africa’, analysed the impact of the mobile web in the region stating that mobile is central to the everyday life of Africans, and that research had shown that seventy percent of smartphone users do not go an hour without checking their mobile phone.\r\n\r\n“As more and more Kenyans and Africans grow online mainly through their mobile phones, advertisers and brand owners have got to fish only where the fishes are,” Mbalu said.\r\n\r\nAlso at the event, Product Manager, Eniola Moronfolu, said that Twinpine, through its advertising formats, enables experiences for mobile users, gives brands prime positioning and publishers more revenue. Moronfolu stated that the Twinpine self-serve platform on which advertising campaigns run is fast, efficient and intelligent.\r\n\r\nThe Kuungana event series hosted by Twinpine explores the expansion and outlook of business in Africa, and is part of the organisation’s ‘Engage, Educate, Empower’ strategy. The series will be continued in other countries in the following months.\r\n\r\nStaff Writer', '2015-04-30', '2014-09-03 23:00:00'),
(17, 1, NULL, 'Zimbabweans can now pay phone bills with telecash', 'It is now possible to pay telephone bills with telecash, following an agreement between Telecel Zimbabwe and TelOne, making it possible to avoid queuing to pay phone bills.\r\n\r\nTelecash subscribers can now pay their phone bills using their mobile phone to make the payment.\r\n\r\nAll that they need to do is dial  *888# to access the telecash menu, select the ‘pay bill’ option and then select Tel One. They will be asked to enter their telephone account number and the amount to be paid. It is as simple as that.\r\n\r\nAs with all telecash transactions, they will be asked to enter their telecash personal identification number (PIN) during the transaction to confirm their identity as the holder of the telecash account connected with their mobile phone.\r\n\r\nOnce payment has been made the subscriber will receive a transaction ID that can be quoted, like a receipt number, in the event of any query. Crediting of the TelOne account takes place almost instantaneously.\r\n\r\nIt is possible to add Tel One to the list of favourites on the telecash menu, so that in future when making payment Tel One can be selected quickly from that list.\r\n\r\nTelecash is an electronic wallet, into which money can be deposited and withdrawn at any telecash agent and from which payments can be made for bills and goods and services. Money can also be transferred from a telecash account to the mobile phone of anyone else, regardless of network.\r\n\r\nIt can also be transferred to a bank account held with a bank that is connected to the ZimSwitch Zipit platform. Salaries can be paid into a telecash account using the telecash bulk payments facility.\r\n\r\nAll that is needed to take advantage of telecash is to have a Telecel line and register for telecash at a Telecel shop or telecash agent or with one of the telecash ambassadors who can be identified by their telecash regalia on the streets of cities and major towns.\r\n\r\nAll Bon Marche, OK Bazaars and TM supermarkets are telecash agents, as too are all post offices.  There are also numerous small agencies, which can be identified by the telecash logo and telecash agent number.\r\n\r\n \r\n\r\nStaff writer', NULL, '2014-06-03 23:00:00'),
(18, 1, NULL, 'Gray market mobile handsets thrive in Kenya', 'Kenya’s mobile handset market recorded year-on-year volume growth of 21.5% in Q1 2014, according to preliminary figures announced today by International Data Corporation (IDC). While various economic and social factors continued to help push this growth, the positive quarterly performance was primarily driven by a vibrant gray market that was boosted by the September 2013 re-introduction of VAT on handsets and other electronic devices.\r\n\r\n“Gray market dealers have been the main beneficiaries of the government’s decision to re-introduce VAT in late 2013, while official channel partners have been badly hit,” says James Mutua, a research analyst with IDC East Africa. “Gray market dealers are known to source their handsets from unofficial/unauthorized channels, which makes their gadgets cheaper than the same products sourced through official partners.”\r\n\r\nThe Kenyan government had exempted mobile handsets from VAT in June 2009. This generated significant benefits for many Kenyans and led to an increase in the volume of shipments to the country, but this all changed with the return of the levy. “An unfair playing field has emerged since these new taxes were implemented, and as a result gray market dealers now account for more than two-thirds of the mobile handset market’s volume,” continues Mutua. “Moreover, these estimates are conservative; the numbers may be significantly higher as some official channel partners are claiming to have lost more than half of their normal monthly run rate business.\r\n\r\nIDC’s latest figures show that smartphone shipments were up 104.6% year on year in Q1 2014, against a paltry rise of just 3.6% for feature phones over the same period. The smartphone category increased its unit share of the overall handset market to 29.8% for the period under review as more consumers invested in the various new gadgets launched since the start of Q4 2013. Some of the models recently introduced to the Kenyan market include, but are not limited to, the LG L1, LG L4, Nokia X, Nokia Lumia 1320, Nokia Lumia 1520, Samsung S3 Lite, Samsung Galaxy Grand 2, Samsung S5, Sony Xperia M2, Apple iPhone 5, Tecno M3, Tecno R7, and various devices from Infinix.\r\n\r\nThe overall handset market in Kenya is dominated by three vendors, namely Nokia, Tecno, and Samsung. Combined, these vendors control around 75% of the market’s total volume. Devices with 2G and 2.5G interfaces still dominate the Kenya handset market. However, 3G and 4G-enabled devices continued to record healthy year-on-year volume growth in Q1 2014 of 67.0% and 207.4% respectively. This is an indication that the Kenyan market’s user base is increasingly ready to join the rest of the world in shifting to LTE.\r\n\r\nHowever, Kenya’s case for 4G (LTE) infrastructure remains in limbo as operators are yet to identify the best network deployment model. IDC expects Kenya to move faster toward 4G deployment once key market stakeholders have agreed on the best approach to take.\r\n\r\nWith prices declining and increasing numbers of Kenyans now accessing the Internet via mobile phones, IDC expects the smartphone segment to continue recording healthy growth over the coming quarters. However, the government needs to be alert to the challenges that lie ahead in terms of the market’s composition, particularly when genuine tax-compliant businesses lose out to gray market dealers that may not fully adhere to the relevant taxation requirements.', '2015-04-30', '2014-05-29 23:00:00'),
(19, 1, NULL, 'Nigeria: How to access Wikipedia for free', 'Leading telecommunications services provider, Airtel Nigeria, has announced a strategic partnership with the Wikimedia Foundation, the non-profit that operates Wikipedia, to offer their consumers across the country access to Wikipedia through their mobile phones free of data charges.\r\nThe initiative, which is first of its kind in Nigeria, is dubbed Wikipedia Zero, and it is aimed at reaching and empowering billions of people around the world whose access to the Internet is primarily through a mobile device. Airtel Nigeria subscribers can access Wikipedia free of data charges at m.wikipedia.org.\r\n\r\nWith the new partnership, Airtel will help deliver knowledge and information of Wikipedia to 21 million of new users in the West African region.\r\nSpeaking on the new partnership, Chief Commercial Officer, Airtel Nigeria, Maurice Newa, said the initiative is in line with the company’s corporate vision of becoming Nigeria’s number one Internet Company, saying the new service will help connect Nigerians with relevant knowledge and information that will empower them to succeed in their personal and professional endeavours.\r\n\r\n“We are excited with our partnership with the Wikimedia Foundation and we will continue to provide innovative solutions that will uplift Nigerians in line with our brand promise of becoming the most loved brand in the daily lives of Nigerians. At Airtel, we are passionate and committed to creating solid educational and youth empowerment platforms that will enrich and transform the lives of telecoms consumers across the country,” he said.\r\n\r\n“We commend Airtel Nigeria for taking a leadership role in empowering their society through information access, and we’re thrilled to partner with them,” said Carolynne Schloeder, Head of Mobile Partnerships at the Wikimedia Foundation. “Expanding Wikipedia Zero to the people of Nigeria is a big step forward for free knowledge in Africa.” ', '2015-04-30', '2014-05-28 23:00:00'),
(20, 1, NULL, 'South Africa: Entrepreneur broadcasts jobs with BBM', 'The Dala U Crew (DUC) is helping thousands of young South Africans to find jobs by tapping into the power of the BBM™, a leading mobile messaging platform for private and secure communications.\r\n\r\nThe initiative, brainchild of young Durban businessman Sanjeev Singh, uses BBM to broadcast job opportunities to a community of 24,000 people.\r\n\r\nDUC started out as youth community focused on keeping people informed about parties, clubs and other events. Singh decided to tap into this community to help people find jobs after a number of people approached him to help them with their searches for employment. Over the past two years, the community has blossomed and Singh carries job advertisements from a range of employers on BBM every week.\r\n\r\nSays Singh: “I realised that BBM would be a wonderful avenue for helping people to find jobs, because it could connect thousands of people around the country to employment opportunities. Now that BBM is available on Android™ and iPhone devices as well as BlackBerry smartphones, nearly anyone has access to the BBM capabilities.”\r\n\r\nSince he started using BBM to connect the community to job opportunities, Singh has quietly helped thousands of South Africans to find jobs. Some employers get 300 to 400 responses for their ads, and around 200 people per week join the DUC community. More recently, Singh set up a DUC mobisite, which gets thousands of views a week.\r\n\r\nNow, DUC plan is also offering other classifieds ads in addition to the job ads. Contacts are able to browse an assortment of services available ranging from jobs, cars for sale, services and photos from events on the company’s mobi site. “The immediacy, reliability and accessibility of BBM is helping us to make a real difference in people’s lives,” says Singh.\r\n\r\nStaff writer', '2015-04-30', '2014-05-26 23:00:00'),
(21, 1, NULL, 'Standard Bank launches game-changing payment app', 'Standard Bank today announced the launch of their mobile payment app, SnapScan. This is the bank’s first mobile payment offering that allows merchants to receive payments from their customers through a combination of a QR code and a secure PIN number.\r\n\r\nAccording to Standard Bank’s Head of Innovation and Channel Design, Vuyo Mpako, “We are excited to bring such innovative offerings to all South African businesses. We created this app together with Stellenbosch-based IT agency, FireID in 2013, and it went on to win the 2013 MTN Business’ App of the year award. After extensive beta testing, we’re ready to take this solution to market.”\r\n\r\nThe challenge that many small enterprises face is the cost of setting up a POS machine combined with interrupted or unreliable connectivity, for example a small business trading at a Saturday market. SnapScan enables small business owners who wouldn’t normally qualify as merchants, to become fully-fledged merchants. All that is required to become a merchant is for the business to register with SnapScan, print the unique QR code and any mobile phone. The business owner can now accept payments from anyone using the SnapScan application.\r\n\r\n“SnapScan works amazingly well for formal and informal enterprises alike. We have created a solution that is as easy to install as it is to collect payments. Our business strategy at Standard Bank is to create accessible, convenient and secure solutions for businesses. SnapScan is a pioneering first,” says Mr Mpako.\r\n\r\nThe process of transacting with this app is really simple. Once the unique QR code has been scanned, purchases are made with a user-selected PIN and the business owner will receive a SMS notification from Standard Bank confirming the transaction. Merchants don’t need any high-tech devices or connectivity – all payment confirmations are delivered using the standard SMS service.\r\n\r\n“For small businesses, this is so much more than an app; it’s a real-time retail payment solution that allows business owners safe, secure and convenient payment methods for their customers. Having SnapScan also minimises potential loss due to the lack of a POS system, essentially creating another sales stream.\r\n\r\n“South Africa has seen a proliferation of smartphones and an increase in apps available to the consumer. There are apps for almost everything from smart diaries to smart banking. A safe and convenient cashless mobile solution was imminent and Standard Bank found it in SnapScan,” says Mr Mpako.\r\n\r\nCollection of funds\r\nSnapScan offers two avenues for the collection of funds. Informal businesses are able to withdraw their earnings by requesting a voucher that can be redeemed at any Spar outlet, or at a Standard Bank ATM. The business owner does not need to have a Standard Bank account to do so.\r\n\r\nThe second option is more geared towards formal businesses, where the sales are directly credited to the nominated business banking account.\r\n\r\nSafety\r\nThe app is extremely secure which minimises card fraud. With the SMS notification service as proof of payment, the business can be sure that the payment is legitimate.\r\n\r\nSnapScan has been successful in businesses across the country and early adopters of this solution include Motherland in Johannesburg and House of Machines in Cape Town.', '2015-04-30', '2014-05-20 23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `news_comment`
--

CREATE TABLE IF NOT EXISTS `news_comment` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `news_reply`
--

CREATE TABLE IF NOT EXISTS `news_reply` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `news_comment_id` mediumint(9) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `picture`
--

CREATE TABLE IF NOT EXISTS `picture` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `album_id` smallint(6) DEFAULT NULL,
  `pic` varchar(20) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tip`
--

CREATE TABLE IF NOT EXISTS `tip` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) DEFAULT NULL,
  `detail` varchar(255) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `tip`
--

INSERT INTO `tip` (`id`, `user_id`, `detail`, `date_added`) VALUES
(1, NULL, 'Develop a clearly defined and focused vision for innovation within your business.', '2015-04-09 18:50:15'),
(2, NULL, 'Develop a set of measurable goals that will clearly define what you want and need to get out of innovation.', '2015-04-09 18:50:15'),
(3, NULL, 'Develop a system for tracking and managing innovation.', '2015-04-09 18:50:15'),
(4, NULL, 'Develop and implement a forum for sharing. Promote the open exchange of ideas and collaboration among your co-workers and team members. The forum could be face-to-face meetings or dong so online with message boards or blogs.', '2015-04-09 18:50:15'),
(5, NULL, 'Engage the powerful technique of brainstorming. The power of brainstorming enables you to address a business challenge, issue or opportunity and is effective because it sets no boundaries and allows people to say whatever they want. ', '2015-04-09 18:50:15'),
(6, NULL, 'Consider establishing an Innovation Team whose priority is ensuring that innovation is a priority and that there is a clearly defined and focused effort to achieve innovation in your business.', '2015-04-09 18:50:15'),
(7, NULL, 'Research what others, outside your organization, do to initiate & inspire innovation. Set a goal to identify 3 or 4 organizations that are very innovative and then request visits to those companies to gain new perspectives on innovation.?', '2015-04-09 18:50:15'),
(8, NULL, 'Commit to personally doing something different from your ordinary routine. For example: try a new coffee house for your morning coffee; take a different route to work; try a new menu item; or anything that you would not typically do on a daily basis.', '2015-04-09 18:50:15'),
(9, NULL, 'Find a business coach or mentor and learn something from them.', '2015-04-09 18:50:15'),
(10, NULL, 'Create some momentum for innovation in your business by selecting and committing to a project that will result in a “quick win” and will provide confirmation that innovation does produce positive results. ', '2015-04-09 18:50:15'),
(11, NULL, 'Create a sense of urgency by setting an aggressive timetable for a project', '2015-04-09 18:50:15'),
(12, NULL, 'Reward creativity and innovation in personal and creative ways. Develop rewards that will appeal personally to an individual’s interests and values.', '2015-04-09 18:50:15'),
(13, NULL, 'Create and foster an environment that is fun and challenging. Creative people have tendencies toward being irreverent and like to have fun.', '2015-04-09 18:50:15'),
(14, NULL, 'Break down individual isolation and create opportunities for people to bounce ideas off of each other. Encourage people out of their workstations and offices to meet in small groups to discuss challenges, issues, trends, opportunities and threats, etc.', '2015-04-09 18:50:15'),
(15, NULL, 'Breakdown hierarchy and emphasize and reward creative and innovative ideas regardless of where they come from in your business.', '2015-04-09 18:50:15'),
(16, NULL, 'Create an environment that will allow everyone to speak freely when working with his or her teams.', '2015-04-09 18:50:15'),
(17, NULL, 'Aim for simplicity so that the innovative ideas are easy to understand, easy to explain to others and relatively easy to implement.', '2015-04-09 18:50:15'),
(18, NULL, 'Focus on the action or the experience and use verbs rather than nouns (e.g. “teach people to think strategically” rather than “strategic thinking education”).', '2015-04-09 18:50:15'),
(19, NULL, 'Adopt an attitude that you will view mistakes and failures as great learning opportunities and blessings in disguise', '2015-04-09 18:50:15'),
(20, NULL, 'If you really want to innovate, give meaning to your product.', '2015-04-09 18:50:15'),
(21, NULL, 'Be willing to polarize people.', '2015-04-09 18:50:15'),
(22, NULL, 'Perfect your pitch.', '2015-04-09 18:50:15'),
(23, NULL, 'Have a Vision for Change.', '2015-04-09 18:50:15'),
(24, NULL, 'Think like a Venture Capitalist.', '2015-04-09 18:50:15'),
(25, 1, 'Niche yourself.', '2015-04-09 18:50:15');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cell` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `org` varchar(100) DEFAULT NULL,
  `desig` varchar(100) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `user_type` char(1) NOT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `firstname`, `lastname`, `email`, `cell`, `dob`, `org`, `desig`, `password`, `user_type`, `date_added`) VALUES
(1, 'mastermind64222', 'Heinrich', 'Aluvilu', 'heirnich91@gmail.com', '0814710142', '1991-11-16', 'Curiosity Made Me Kat', 'Software Develper/ Graphics Designer', '242499', '1', '2015-04-04 08:17:10');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
