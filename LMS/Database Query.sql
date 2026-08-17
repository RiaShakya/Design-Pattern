--
-- PostgreSQL database dump
--

\restrict qjPmbZ2MTCNMf2tiERsWK1TZMCRn4Xvc8QQ5KKt2KsQmG4IJLUlFwF44U1ePbwW

-- Dumped from database version 18.4
-- Dumped by pg_dump version 18.4

-- Started on 2026-08-17 16:46:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 229 (class 1259 OID 33239)
-- Name: admins; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admins (
    admin_id integer NOT NULL,
    username character varying(50),
    password character varying(100)
);


ALTER TABLE public.admins OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 33238)
-- Name: admins_admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admins_admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.admins_admin_id_seq OWNER TO postgres;

--
-- TOC entry 5073 (class 0 OID 0)
-- Dependencies: 228
-- Name: admins_admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admins_admin_id_seq OWNED BY public.admins.admin_id;


--
-- TOC entry 221 (class 1259 OID 33168)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    book_id integer NOT NULL,
    title character varying(200) NOT NULL,
    author character varying(100) NOT NULL,
    status character varying(20) DEFAULT 'AVAILABLE'::character varying NOT NULL,
    CONSTRAINT books_status_check CHECK (((status)::text = ANY ((ARRAY['AVAILABLE'::character varying, 'ISSUED'::character varying])::text[])))
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33167)
-- Name: books_book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.books_book_id_seq OWNER TO postgres;

--
-- TOC entry 5074 (class 0 OID 0)
-- Dependencies: 220
-- Name: books_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_book_id_seq OWNED BY public.books.book_id;


--
-- TOC entry 223 (class 1259 OID 33181)
-- Name: borrow_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.borrow_records (
    borrow_id integer NOT NULL,
    member_id character varying(20) NOT NULL,
    book_id integer NOT NULL,
    borrow_date date NOT NULL,
    due_date date DEFAULT (CURRENT_DATE + 14) NOT NULL,
    return_date date
);


ALTER TABLE public.borrow_records OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33180)
-- Name: borrow_records_borrow_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.borrow_records_borrow_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.borrow_records_borrow_id_seq OWNER TO postgres;

--
-- TOC entry 5075 (class 0 OID 0)
-- Dependencies: 222
-- Name: borrow_records_borrow_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.borrow_records_borrow_id_seq OWNED BY public.borrow_records.borrow_id;


--
-- TOC entry 219 (class 1259 OID 33154)
-- Name: members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.members (
    member_id character varying(20) NOT NULL,
    member_code character varying(20) GENERATED ALWAYS AS (member_id) STORED,
    full_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(20),
    address character varying(200),
    password character varying(100)
);


ALTER TABLE public.members OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 33221)
-- Name: notifications; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notifications (
    notification_id integer NOT NULL,
    member_id character varying(20) NOT NULL,
    message text NOT NULL,
    notification_type character varying(30),
    sent_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.notifications OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 33220)
-- Name: notifications_notification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notifications_notification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.notifications_notification_id_seq OWNER TO postgres;

--
-- TOC entry 5076 (class 0 OID 0)
-- Dependencies: 226
-- Name: notifications_notification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notifications_notification_id_seq OWNED BY public.notifications.notification_id;


--
-- TOC entry 225 (class 1259 OID 33204)
-- Name: payments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payments (
    payment_id integer NOT NULL,
    member_id character varying(20) NOT NULL,
    amount numeric(10,2) NOT NULL,
    payment_method character varying(50) NOT NULL,
    payment_date date NOT NULL
);


ALTER TABLE public.payments OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33203)
-- Name: payments_payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payments_payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.payments_payment_id_seq OWNER TO postgres;

--
-- TOC entry 5077 (class 0 OID 0)
-- Dependencies: 224
-- Name: payments_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payments_payment_id_seq OWNED BY public.payments.payment_id;


--
-- TOC entry 4888 (class 2604 OID 33242)
-- Name: admins admin_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins ALTER COLUMN admin_id SET DEFAULT nextval('public.admins_admin_id_seq'::regclass);


--
-- TOC entry 4881 (class 2604 OID 33171)
-- Name: books book_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books ALTER COLUMN book_id SET DEFAULT nextval('public.books_book_id_seq'::regclass);


--
-- TOC entry 4883 (class 2604 OID 33184)
-- Name: borrow_records borrow_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow_records ALTER COLUMN borrow_id SET DEFAULT nextval('public.borrow_records_borrow_id_seq'::regclass);


--
-- TOC entry 4886 (class 2604 OID 33224)
-- Name: notifications notification_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notifications ALTER COLUMN notification_id SET DEFAULT nextval('public.notifications_notification_id_seq'::regclass);


--
-- TOC entry 4885 (class 2604 OID 33207)
-- Name: payments payment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments ALTER COLUMN payment_id SET DEFAULT nextval('public.payments_payment_id_seq'::regclass);


--
-- TOC entry 5067 (class 0 OID 33239)
-- Dependencies: 229
-- Data for Name: admins; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admins (admin_id, username, password) FROM stdin;
1	admin	admin123
\.


--
-- TOC entry 5059 (class 0 OID 33168)
-- Dependencies: 221
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.books (book_id, title, author, status) FROM stdin;
1	It Ends With Us	Colleen Hoover	ISSUED
4	The Alchemist	Paulo Coelho	ISSUED
8	Ikigai	Francesc Miralles	AVAILABLE
7	Clean Code	Robert C. Martin	AVAILABLE
6	Harry Potter	J.K.Rowling	AVAILABLE
9	Pride and Prejudice	Jane Austen	AVAILABLE
2	Deserted Village	GoldSmith	ISSUED
\.


--
-- TOC entry 5061 (class 0 OID 33181)
-- Dependencies: 223
-- Data for Name: borrow_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.borrow_records (borrow_id, member_id, book_id, borrow_date, due_date, return_date) FROM stdin;
1	M001	4	2026-08-04	2026-08-18	2026-08-04
2	M001	2	2026-08-05	2026-08-08	2026-08-09
4	M001	4	2026-08-06	2026-08-09	2026-08-09
6	M004	4	2026-08-09	2026-08-12	\N
9	M002	8	2026-08-12	2026-08-15	2026-08-12
3	M003	6	2026-08-06	2026-08-09	2026-08-12
5	M001	7	2026-08-09	2026-08-12	2026-08-12
10	M001	6	2026-08-17	2026-08-20	2026-08-17
\.


--
-- TOC entry 5057 (class 0 OID 33154)
-- Dependencies: 219
-- Data for Name: members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.members (member_id, full_name, email, phone, address, password) FROM stdin;
M002	Salina Shrestha	salina@gmail.com	987451254	Lubhu	\N
M001	Ria Shakya	riashakya@gmail.com	98745145474	Patan	\N
M003	Alisha Shakya	alisha12@gmail.com	9845124758	Patan	\N
M004	Binita Manandhar	binita12@gmail.com	9845125415	Ekantakuna	\N
\.


--
-- TOC entry 5065 (class 0 OID 33221)
-- Dependencies: 227
-- Data for Name: notifications; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notifications (notification_id, member_id, message, notification_type, sent_date) FROM stdin;
2	M002	Book "Ikigai" has been ISSUED to M002. Please return it within 3 days.	EMAIL	2026-08-12 21:49:56.096723
3	M003	Fine payment of NPR 50.0 received successfully.	OBSERVER	2026-08-12 21:54:24.667617
4	M001	Fine payment of NPR 50.0 received successfully.	OBSERVER	2026-08-13 07:36:45.786311
5	M001	Book "Harry Potter" has been ISSUED to M001. Please return it within 3 days.	EMAIL	2026-08-17 16:32:57.321356
\.


--
-- TOC entry 5063 (class 0 OID 33204)
-- Dependencies: 225
-- Data for Name: payments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payments (payment_id, member_id, amount, payment_method, payment_date) FROM stdin;
1	M001	50.00	card	2026-08-05
2	M001	40.00	cash	2026-08-05
3	M001	50.00	card	2026-08-09
4	M001	50.00	cash	2026-08-12
5	M003	50.00	esewa	2026-08-12
6	M001	50.00	esewa	2026-08-13
\.


--
-- TOC entry 5078 (class 0 OID 0)
-- Dependencies: 228
-- Name: admins_admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admins_admin_id_seq', 1, true);


--
-- TOC entry 5079 (class 0 OID 0)
-- Dependencies: 220
-- Name: books_book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_book_id_seq', 9, true);


--
-- TOC entry 5080 (class 0 OID 0)
-- Dependencies: 222
-- Name: borrow_records_borrow_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.borrow_records_borrow_id_seq', 10, true);


--
-- TOC entry 5081 (class 0 OID 0)
-- Dependencies: 226
-- Name: notifications_notification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notifications_notification_id_seq', 5, true);


--
-- TOC entry 5082 (class 0 OID 0)
-- Dependencies: 224
-- Name: payments_payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payments_payment_id_seq', 6, true);


--
-- TOC entry 4903 (class 2606 OID 33245)
-- Name: admins admins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (admin_id);


--
-- TOC entry 4905 (class 2606 OID 33247)
-- Name: admins admins_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_username_key UNIQUE (username);


--
-- TOC entry 4895 (class 2606 OID 33179)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);


--
-- TOC entry 4897 (class 2606 OID 33192)
-- Name: borrow_records borrow_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow_records
    ADD CONSTRAINT borrow_records_pkey PRIMARY KEY (borrow_id);


--
-- TOC entry 4891 (class 2606 OID 33166)
-- Name: members members_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members
    ADD CONSTRAINT members_email_key UNIQUE (email);


--
-- TOC entry 4893 (class 2606 OID 33164)
-- Name: members members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members
    ADD CONSTRAINT members_pkey PRIMARY KEY (member_id);


--
-- TOC entry 4901 (class 2606 OID 33232)
-- Name: notifications notifications_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_pkey PRIMARY KEY (notification_id);


--
-- TOC entry 4899 (class 2606 OID 33214)
-- Name: payments payments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT payments_pkey PRIMARY KEY (payment_id);


--
-- TOC entry 4906 (class 2606 OID 33198)
-- Name: borrow_records fk_borrow_book; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow_records
    ADD CONSTRAINT fk_borrow_book FOREIGN KEY (book_id) REFERENCES public.books(book_id) ON DELETE CASCADE;


--
-- TOC entry 4907 (class 2606 OID 33193)
-- Name: borrow_records fk_borrow_member; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow_records
    ADD CONSTRAINT fk_borrow_member FOREIGN KEY (member_id) REFERENCES public.members(member_id) ON DELETE CASCADE;


--
-- TOC entry 4909 (class 2606 OID 33233)
-- Name: notifications fk_notification_member; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT fk_notification_member FOREIGN KEY (member_id) REFERENCES public.members(member_id) ON DELETE CASCADE;


--
-- TOC entry 4908 (class 2606 OID 33215)
-- Name: payments fk_payment_member; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payments
    ADD CONSTRAINT fk_payment_member FOREIGN KEY (member_id) REFERENCES public.members(member_id) ON DELETE CASCADE;


-- Completed on 2026-08-17 16:46:33

--
-- PostgreSQL database dump complete
--

\unrestrict qjPmbZ2MTCNMf2tiERsWK1TZMCRn4Xvc8QQ5KKt2KsQmG4IJLUlFwF44U1ePbwW

